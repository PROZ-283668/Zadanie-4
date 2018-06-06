package nbpapi;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("exchangerates/rates")
public class Main
{
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{table}/{currency}/{topCount}")
    public String getText(@PathParam("table") String table, @PathParam("currency") String currency,
	    @PathParam("topCount") Integer topCount)
    {
	return "Average exchange rate for " + currency + " from table " + table + " for the last " + topCount
		+ " days is: " + AverageRateCalculator.average(table, currency, topCount) + " PLN";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("{table}/{currency}/{topCount}")
    public String getHtml(@PathParam("table") String table, @PathParam("currency") String currency,
	    @PathParam("topCount") Integer topCount)
    {
	return "<html><body><p>Average exchange rate for " + currency + " from table "
		+ table + " for the last " + topCount + " days is: "
		+ AverageRateCalculator.average(table, currency, topCount) + " PLN</p></body></html>";
    }

    @GET
    @Path("{table}/{currency}/{topCount}")
    @Produces(MediaType.TEXT_XML)
    public String getXML(@PathParam("table") String table, @PathParam("currency") String currency,
	    @PathParam("topCount") Integer topCount)
    {
	return "<?xml version=\"1.0\"?>" + "<code>" + currency + "</code>" + "<table>" + table + "</table>"
		+ "<topCount>" + topCount + "</topCount>" + "<avg>"
		+ AverageRateCalculator.average(table, currency, topCount) + "</avg>";
    }

    @GET
    @Path("{table}/{currency}/{topCount}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJSON(@PathParam("table") String table, @PathParam("currency") String currency,
	    @PathParam("topCount") Integer topCount)
    {
	JsonObjectBuilder objBuilder = Json.createObjectBuilder();
	objBuilder.add("table", table).add("topCount", topCount).add("code", currency).add("average",
		AverageRateCalculator.average(table, currency, topCount));
	JsonObject jsonObj = objBuilder.build();
	return jsonObj.toString();
    }
}
