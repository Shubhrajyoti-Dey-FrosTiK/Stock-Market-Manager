package Info;

import java.math.BigDecimal;
import java.util.List;

import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

public class StockInfo {
    public String Currency;
    public List<yahoofinance.histquotes.HistoricalQuote> History;
    public String Name;
    public BigDecimal Change;
    public BigDecimal Bid;
    public BigDecimal Price;
    public String Symbol;
    public Boolean isValid;
    public StockQuote Quote;
    public BigDecimal PreviousClose;
    public BigDecimal DayHigh;
    public BigDecimal DayLow;
    public BigDecimal YearHigh;
    public BigDecimal YearLow;
    public BigDecimal Avg200;
    public BigDecimal Change50;
    public BigDecimal Change50P;
    public BigDecimal Change200;
    public BigDecimal Change200P;
    public BigDecimal Open;
}
