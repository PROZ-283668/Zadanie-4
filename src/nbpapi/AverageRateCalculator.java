package nbpapi;

import java.io.StringReader;
import java.text.DecimalFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class AverageRateCalculator
{
    public static String average(String table, String currency, Integer topCount)
    {
	NBPCallHandler callHandler = new NBPCallHandler();
	String data = callHandler.callNBP(table, currency, topCount);

	try
	{
	    JAXBContext context = JAXBContext.newInstance(ExchangeRatesSeries.class);
	    Unmarshaller unmarshaller = context.createUnmarshaller();
	    StringReader reader = new StringReader(data);
	    ExchangeRatesSeries series = (ExchangeRatesSeries) unmarshaller.unmarshal(reader);
	    DecimalFormat df = new DecimalFormat("###.###");
	    return new String(df.format(series.average()));
	} catch (JAXBException e)
	{
	    e.printStackTrace();
	}

	return new String();
    }
}
