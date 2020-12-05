package endPoint;
import javax.xml.ws.Endpoint;
import webServise.webServiseFunc;
public class webServisePublisher {
    public static void main(String... args) {
        Endpoint.publish("http://localhost:1986/wss/hello", new webServiseFunc());
    }
}