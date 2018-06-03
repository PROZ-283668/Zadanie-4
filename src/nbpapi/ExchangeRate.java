package nbpapi;

import javax.xml.bind.annotation.XmlElement;

public class ExchangeRate
{
    @XmlElement(name = "Ask")
    private Double Ask;
    @XmlElement(name = "Mid")
    private Double Mid;

    ExchangeRate()
    {
	Ask = 0.0;
	Mid = 0.0;
    }

    public void setAsk(Double Ask)
    {
	this.Ask = Ask;
    }

    public Double getAsk()
    {
	return Ask;
    }

    public void setMid(Double Mid)
    {
	this.Mid = Mid;
    }

    public Double getMid()
    {
	return Mid;
    }
}
