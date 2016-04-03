package Task;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;
import java.util.TimerTask;

import service.StockDataService;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class FetchDataTask extends TimerTask {

    @Override
    public void run(){
        try {
            Set<String> list = StockDataService.getInstance().getSymbolList();
            for(Iterator<String> iterator = list.iterator(); iterator != null && iterator.hasNext();) {
                String symbol = iterator.next();
                Stock stock = YahooFinance.get(symbol);
                BigDecimal price = stock.getQuote(true).getPrice();
                StockDataService.getInstance().updatePrice(symbol, price);                
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
