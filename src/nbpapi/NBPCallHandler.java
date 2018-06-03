package nbpapi;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

public class NBPCallHandler
{
    private Client client;
    private URI uri;

    NBPCallHandler()
    {
	client = ClientBuilder.newClient();
	uri = UriBuilder.fromUri("http://api.nbp.pl/api/exchangerates/rates").build();
    }

    public String callNBP(String table, String currency, Integer topCount)
    {
	WebTarget webTarget = client.target(uri).path(table + "/" + currency + "/last/" + topCount.toString());

	return webTarget.request().accept(MediaType.TEXT_XML).get(String.class);
    }
}
