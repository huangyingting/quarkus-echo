package org.acme;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.HttpHeaders;

@Path("/{.+}")
public class EchoResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders headers) {        
        return echo(request, uriInfo, headers);
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders headers) {        
        return echo(request, uriInfo, headers);
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String post(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders headers, String payload) {
        StringBuilder response = new StringBuilder();
        response.append(echo(request, uriInfo, headers));
        response.append("\r\n");
        response.append(payload);
        return response.toString();
    }
    
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String put(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders headers, String payload) {
        StringBuilder response = new StringBuilder();
        response.append(echo(request, uriInfo, headers));
        response.append("\r\n");
        response.append(payload);
        return response.toString();
    }
    
    private String echo(Request request, UriInfo uriInfo, HttpHeaders headers) {
        StringBuilder response = new StringBuilder();
        response.append(":method: " + request.getMethod() + "\r\n");
        response.append(":url: " + uriInfo.getRequestUri() + "\r\n");
        headers.getRequestHeaders().forEach(
            (key, values) -> response.append(key + ": " + values.toString() + "\r\n"));
        return response.toString();        
    }

}