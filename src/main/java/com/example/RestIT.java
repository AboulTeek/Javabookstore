@Path("/")
public class RestEndpoint {
    @GET
    public String hello() {
        return "Welcome to Baeldung!";
    }
}