package edu.canisius.csc213.project2.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.canisius.csc213.project2.quotes.*;
import java.io.IOException;

public class PolygonJsonReplyTranslator {
    public StockQuote translateJsonToFinancialInstrument(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);
        String symbol = rootNode.get("ticker").asText();
        JsonNode resultsNode = rootNode.path("results");
        JsonNode resultNode = resultsNode.get(0);

        double closePrice = resultNode.get("c").asDouble();
        double highestPrice = resultNode.get("h").asDouble();
        double lowestPrice = resultNode.get("l").asDouble();
        int numberOfTransactions = resultNode.get("n").asInt();
        double openPrice = resultNode.get("o").asDouble();
        long timestamp = resultNode.get("t").asLong();
        double tradingVolume = resultNode.get("v").asDouble();

        return new StockQuote(symbol, closePrice, highestPrice, lowestPrice, numberOfTransactions, openPrice, timestamp, tradingVolume);
    }
}