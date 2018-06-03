package nbpapi;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ExchangeRatesSeries")
public class ExchangeRatesSeries
{
    @XmlElement(name = "Table")
    private String Table;

    @XmlElement(name = "Currency")
    private String Currency;

    @XmlElement(name = "Code")
    private String Code;

    @XmlElementWrapper(name = "Rates")
    @XmlElement(name = "Rate")
    private List<ExchangeRate> Rates = new ArrayList<ExchangeRate>();

    public String getTable()
    {
	return Table;
    }

    public void setTable(String Table)
    {
	this.Table = Table;
    }

    public String getCode()
    {
	return Code;
    }

    public void setCode(String Code)
    {
	this.Code = Code;
    }

    public String getCurrency()
    {
	return Currency;
    }

    public void setCurrency(String Currency)
    {
	this.Currency = Currency;
    }

    public List<ExchangeRate> getRate()
    {
	return Rates;
    }

    public void setRate(List<ExchangeRate> Rates)
    {
	this.Rates = Rates;
    }

    public Double average()
    {
	Double sum = 0.0;

	for (ExchangeRate rate : Rates)
	{
	    Double ask = rate.getAsk(), mid = rate.getMid();
	    if (ask > 0)
		sum += ask;
	    else if (mid > 0)
		sum += mid;
	}
	return sum / Rates.size();
    }
}
