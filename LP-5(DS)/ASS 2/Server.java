import java.rmi.*;

public class Server {
    public static void main(String[] args) {
        try {
            MyImpl obj = new MyImpl();

            Naming.rebind("rmi://localhost/MyService", obj);

            System.out.println("Server is ready...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}