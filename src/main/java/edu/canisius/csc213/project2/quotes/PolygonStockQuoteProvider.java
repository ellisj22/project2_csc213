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

    public static String sendGetRequest(String endpointUrl) throws IOException {
        StringBuilder response = new StringBuilder();
        URL url = new URL(endpointUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        return response.toString();
    }

}
