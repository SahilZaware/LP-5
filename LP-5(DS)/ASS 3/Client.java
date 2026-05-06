import CalculatorApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;

public class Client {
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            Calculator obj = CalculatorHelper.narrow(ncRef.resolve_str("Calculator"));

            int result = obj.add(5, 3);

            System.out.println("Result = " + result);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}