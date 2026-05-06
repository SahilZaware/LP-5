import CalculatorApp.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;

public class Server {
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);

            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            CalculatorImpl obj = new CalculatorImpl();

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(obj);
            Calculator href = CalculatorHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            ncRef.rebind(ncRef.to_name("Calculator"), href);

            System.out.println("Server ready...");
            orb.run();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}