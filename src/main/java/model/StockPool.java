package model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;


public class StockPool {

    private Map<String, StockPrice> pool = new HashMap<String, StockPrice>();
    private Set<String> symbols = new HashSet<String>();
    
    public void addStockSymbol(String symbol) {
        try {
            symbols.add(symbol);
            StockPrice stockPrice = new StockPrice();
            stockPrice.setSymbol(symbol);
            Stock stock = YahooFinance.get(symbol);
            BigDecimal price = stock.getQuote().getPrice();
            BigDecimal openPrice = stock.getQuote().getOpen();
            stockPrice.setPrice(price);
            stockPrice.setIncrease(price.compareTo(openPrice) >= 0);
            stockPrice.setDifference(price.subtract(openPrice));
            pool.put(symbol, stockPrice);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
    }
    
    public Set<String> getSymbols() {
        return symbols;
    }
    
    public Map<String, StockPrice> getPool() {
        return pool;
    }
    public void deleteStockSymbol(String symbol) {
        pool.remove(symbol);
        symbols.remove(symbol);
    }
    
    public void updatePrice(String symbol, BigDecimal price) {
        BigDecimal lastPrice = pool.get(symbol).getPrice();
        pool.get(symbol).setPrice(price);
        pool.get(symbol).setIncrease(price.compareTo(lastPrice) >= 0);
        pool.get(symbol).setDifference(price.subtract(lastPrice));
        System.out.print(pool);
    }
}
