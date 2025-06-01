import CalcNum.*;
import com.zeroc.Ice.*;
import java.util.concurrent.CompletableFuture;
import java.lang.Exception;

public class Master implements CalculatorPerfectNum {

  private static WorkerPrx worker;

  public Master() {
    try {
      Communicator communicator = Util.initialize(new String[] {}, "master.config");
      ObjectPrx base = communicator.propertyToProxy("serverWorker.proxy");
      worker = WorkerPrx.checkedCast(base);

      if (worker == null) {
        throw new Error("Proxy nulo - ¿Se pudo conectar al servidor Worker?");
      }
      System.out.println("Master conectado a Worker.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public String calNumber(double x, double y, Current current) {

    String res = "N/N";

    try {

      
      int start = (int) x;
      int end = (int) y;
      
      int mid = (int) end/2;
      
      String response1 = "";
      String response2 = "";
      
      
      CompletableFuture<String> responseAsync = worker.calcNumberInRangeAsync(start, mid);
      CompletableFuture<String> responseAsync2 = worker.calcNumberInRangeAsync(mid+1, end);
      
      // String res = worker.calcNumberInRange(start, mid);
      // String res2 = worker.calcNumberInRange(mid+1, end);
      
      response1 = responseAsync.get() + " - tiempo(ms): " + System.currentTimeMillis();
      response2 = responseAsync2.get() + " - tiempo(ms): " + System.currentTimeMillis();
      
      
      res = "Lista de numeros perfectos entre ("+start+") - ("+mid+"): " + response1 + " de (" + (mid+1) +") - ("+end+"): "+ response2;
      // res = "Lista de numeros perfectos entre ("+start+") - ("+mid+"): " + res + " de (" + (mid+1) +") - ("+end+"): "+ res2;
      
    } catch(Exception e) {

    }
    return res;
  }

}
