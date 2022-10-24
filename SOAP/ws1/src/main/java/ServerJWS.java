import jakarta.xml.ws.Endpoint;
import ws.BanqueSErvice;

public class ServerJWS {
    public static void main(String[] args) {
        Endpoint.publish("http://0.0.0.0:9191/", new BanqueSErvice());
        System.out.println("Web service déployé sur http://0.0.0.0:9191/");
    }
}
