package edu.canisius.csc213.project2.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.canisius.csc213.project2.quotes.*;
import java.io.IOException;

public class PolygonJsonReplyTranslator {
    public StockQuote translateJsonToFinancialInstrument(String json) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);

            // Check if required fields exist
            if (!rootNode.has("ticker") || !rootNode.has("results")) {
                throw new IllegalArgumentException("Invalid JSON structure. Missing required fields.");
            }

            String symbol = rootNode.get("ticker").asText();
            JsonNode resultsNode = rootNode.get("results");

            if (resultsNode.isArray() && resultsNode.size() > 0) {
                JsonNode firstResult = resultsNode.get(0);
                // Access the fields from the first element of the "results" array
                double closePrice = getDoubleValue(firstResult, "c");
                double highestPrice = getDoubleValue(firstResult, "h");
                double lowestPrice = getDoubleValue(firstResult, "l");
                int numOfTransactions = getIntValue(firstResult, "n");
                double openPrice = getDoubleValue(firstResult, "o");
                long timestamp = getLongValue(firstResult, "t");
                double tradingVolume = getDoubleValue(firstResult, "v");

                return new StockQuote(symbol, closePrice, highestPrice, lowestPrice, numOfTransactions, openPrice, timestamp, tradingVolume);
            } else {
                throw new IllegalArgumentException("Invalid JSON structure. 'results' array is empty.");
            }
        } catch (JsonProcessingException e) {
            throw new IOException("Failed to parse JSON", e);
        } catch (IllegalArgumentException e) {
            throw new IOException("Invalid JSON structure", e);
        }
    }

    private double getDoubleValue(JsonNode node, String fieldName) {
        if (node.has(fieldName) && node.get(fieldName).isNumber()) {
            return node.get(fieldName).asDouble();
        }
        throw new IllegalArgumentException("Invalid value for field: " + fieldName);
    }

    private int getIntValue(JsonNode node, String fieldName) {
        if (node.has(fieldName) && node.get(fieldName).isNumber()) {
            return node.get(fieldName).asInt();
        }
        throw new IllegalArgumentException("Invalid value for field: " + fieldName);
    }

    private long getLongValue(JsonNode node, String fieldName) {
        if (node.has(fieldName) && node.get(fieldName).isNumber()) {
            return node.get(fieldName).asLong();
        }
        throw new IllegalArgumentException("Invalid value for field: " + fieldName);
    }
}
