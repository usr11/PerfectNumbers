import CalcNum.*;
import com.zeroc.Ice.*;
import java.util.concurrent.CompletableFuture;
import java.lang.Exception;

public class Master implements CalculatorPerfectNum {

  private static WorkerPrx workerPrx;

  public Master() {
    try {
      Communicator communicator = Util.initialize(new String[] {}, "master.config");
      ObjectPrx base = communicator.propertyToProxy("serverWorker.proxy");
      workerPrx = WorkerPrx.checkedCast(base);

      if (workerPrx == null) {
        throw new Error("Proxy nulo - ¿Se pudo conectar al servidor Worker?");
      }
      System.out.println("Master conectado a Worker.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public String calNumber(double x, double y, Current current) {

    int start = (int) x;
    int end = (int) y;

    String res = workerPrx.calcNumberInRange(start, end);

    return "sisisis kkkk" + res;

  }

}
