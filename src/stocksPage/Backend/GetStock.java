package stocksPage.Backend;

import java.io.IOException;

import Info.StockInfo;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class GetStock {
    public StockInfo getStock(String stockname) throws IOException{

        StockInfo dto = new StockInfo();
        Stock stock = YahooFinance.get(stockname);
        // dto = new StockDto(stock.getName(),stock.getQuote().getPrice(),stock.getQuote().getChange(),stock.getCurrency(),stock.getQuote().getBid());
        if(stock.isValid()==true){
            dto.Name = stock.getName();
            dto.Price = stock.getQuote().getDayHigh();
            dto.Change = stock.getQuote().getChange();
            dto.Currency = stock.getCurrency();
            dto.Bid = stock.getQuote().getBid();
            dto.History = stock.getHistory();
            dto.Symbol = stock.getSymbol();
            dto.Quote = stock.getQuote();
            dto.PreviousClose = stock.getQuote().getPreviousClose();
            dto.Change200 = stock.getQuote().getChangeFromAvg200();
            dto.Avg200 = stock.getQuote().getPriceAvg200();
            dto.DayLow = stock.getQuote().getDayLow();
            dto.DayHigh = stock.getQuote().getDayHigh();
            dto.YearHigh = stock.getQuote().getYearHigh();
            dto.YearLow = stock.getQuote().getYearLow();
            dto.Change200P = stock.getQuote().getChangeFromAvg200InPercent();
            dto.Change50 =  stock.getQuote().getChangeFromAvg50();
            dto.Change50P = stock.getQuote().getChangeFromAvg50InPercent();
            dto.Open = stock.getQuote().getOpen();
            dto.isValid = true;
        }else{dto.isValid = false;}
        
		return dto;
	}
}
