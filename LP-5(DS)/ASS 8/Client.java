public class Client {
    public static void main(String[] args) {

        HelloService service = new HelloService();

        String result = service.sayHello("Sanket");

        System.out.println(result);
    }
}