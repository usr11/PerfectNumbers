import com.zeroc.Ice.*;

public class ServerWorker {

      public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args, "serverWorker.config")) {
            ObjectAdapter adapter = communicator.createObjectAdapter("services");
            WorkerI object = new WorkerI();
            adapter.add(object, com.zeroc.Ice.Util.stringToIdentity("Worker"));
            adapter.activate();
            System.out.println("Servidor workers en funcionamiento...");
            communicator.waitForShutdown();
        } 
    }
  
}
