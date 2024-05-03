package edu.canisius.csc213.project2.quotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.canisius.csc213.project2.util.*;

public class PolygonStockQuoteProvider implements StockQuoteProvider{

    @Override
    public StockQuote getStockQuote(String stockQuoteEndpoint) throws IOException {
        String json = sendGetRequest(stockQuoteEndpoint);
        PolygonJsonReplyTranslator jft = new PolygonJsonReplyTranslator();
        return jft.translateJsonToFinancialInstrument(json);

    }

    public String getEndpointUrl(String symbolName, String date, String apiKey) {
        String baseUrl = "https://api.polygon.io/v2/aggs/ticker/";

    if (symbolName == null || symbolName.isEmpty() ||
        date == null || date.isEmpty() ||
        apiKey == null || apiKey.isEmpty()) {
        throw new IllegalArgumentException("Invalid input parameters. All fields must be non-empty.");
    }

    if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
        throw new IllegalArgumentException("Invalid date format. Expected format: yyyy-MM-dd");
    }

    String endpointUrl = baseUrl + symbolName + "/range/1/day/" + date + "/" + date + "?apiKey=" + apiKey;

    return endpointUrl;
}

    public static String sendGetRequest(String endpointUrl) {
        try {
            URL url = new URL(endpointUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder responseData = new StringBuilder();
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    responseData.append(inputLine);
                }
                reader.close();
                return responseData.toString();
            } else {
                System.out.println("Failed to fetch data from URL. Status code: " + statusCode);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
