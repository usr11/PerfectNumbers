import CalcNum.*;
import com.zeroc.Ice.*;

public class Server {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args, "server.config")) {
            ObjectAdapter adapter = communicator.createObjectAdapter("services");
            CalculatorI object = new CalculatorI();
            adapter.add(object, com.zeroc.Ice.Util.stringToIdentity("CalculatorPerfectNum"));
            adapter.activate();
            System.out.println("Servidor de cálculo en funcionamiento...");
            communicator.waitForShutdown();
        } 
    }
}
