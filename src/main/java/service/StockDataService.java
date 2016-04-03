package service;

import java.math.BigDecimal;
import java.util.Set;

import com.google.gson.Gson;

import model.StockPool;

public class StockDataService {
    static final StockDataService STOCK_DATA_SERVICE = new StockDataService();
    private StockDataService() {}
    
    private StockPool stockPool = new StockPool();
    
    public static StockDataService getInstance() {
        return STOCK_DATA_SERVICE;
    }
    
    public Set<String> getSymbolList() {
        return stockPool.getSymbols();
    }
    
    public void updatePrice(String symbol, BigDecimal price) {
        stockPool.updatePrice(symbol, price);
    }
    public void addSymbol(String symbol) {
        stockPool.addStockSymbol(symbol);
    }
    public String getJsonStockData() {
        String result = "";
        try {
            Gson mapper = new Gson();
            result = mapper.toJson(stockPool.getPool());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
        
    }
    
}
