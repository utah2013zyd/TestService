package model;

import java.math.BigDecimal;

public class StockPrice {

    private String symbol;
    private BigDecimal price;
    private boolean isIncrease;
    private BigDecimal difference;
    
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public boolean isIncrease() {
        return isIncrease;
    }
    public void setIncrease(boolean isIncrease) {
        this.isIncrease = isIncrease;
    }
    public BigDecimal getDifference() {
        return difference;
    }
    public void setDifference(BigDecimal difference) {
        this.difference = difference;
    }
    
}
