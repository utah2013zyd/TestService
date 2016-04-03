package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.StockPool;
import service.StockDataService;

public class TestServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = -1454505397788976186L;
    

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String symbol = request.getParameter("symbol");
        StockDataService.getInstance().addSymbol(symbol);
        response.setContentType("application/json");
        response.getWriter().write(StockDataService.getInstance().getJsonStockData());
    }
    

}
