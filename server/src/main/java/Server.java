import CalcNum.*;
import com.zeroc.Ice.*;

public class Server {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args, "server.config")) {
            ObjectAdapter adapter = communicator.createObjectAdapter("services");
            Master object = new Master();
            adapter.add(object, com.zeroc.Ice.Util.stringToIdentity("CalculatorPerfectNum"));
            adapter.activate();
            System.out.println("Servidor de master en funcionamiento...");
            communicator.waitForShutdown();
        } 
    }
}
