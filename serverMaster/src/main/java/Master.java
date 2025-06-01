import CalcNum.*;
import com.zeroc.Ice.*;
import java.util.concurrent.CompletableFuture;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

public class Master implements CalculatorPerfectNum {

  private static WorkerPrx worker;
  private static final int MAX_CONCURRENT_TASKS = 10;

  public Master() {
    try {
      Communicator communicator = Util.initialize(new String[] {}, "master.config");
      ObjectPrx base = communicator.propertyToProxy("serverWorker.proxy");
      worker = WorkerPrx.checkedCast(base);

      if (worker == null) {
        throw new Error("Proxy nulo - ¿Se pudo conectar al servidor Worker?");
      }
      System.out.println("Master conectado a Workers.");
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
      int totalRange = end - start + 1;
      int numWorkers = calculateOptimalWorkers(totalRange);

      long inicialTime = System.currentTimeMillis();

      List<CompletableFuture<String>> futures = new ArrayList<>();
      List<Long> tiempos = new ArrayList<>();

      int step = totalRange / numWorkers;
      int remainder = totalRange % numWorkers;

      int currentStart = start;

      for (int i = 0; i < numWorkers; i++) {
        int currentEnd = currentStart + step - 1;
        if (i == numWorkers - 1) {
          currentEnd += remainder; // ultimo worker
        }

        final int workerStart = currentStart;
        final int workerEnd = currentEnd;

        long startTime = System.currentTimeMillis();
        CompletableFuture<String> future = worker.calcNumberInRangeAsync(workerStart, workerEnd)
          .thenApply(result  -> {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            synchronized (tiempos) {
              tiempos.add(duration);
            }
            return " de (" + workerStart + ") - (" + workerEnd + "): " + result + " - tiempo(ms): " + duration;
          });

        futures.add(future);
        currentStart = currentEnd + 1;
      }

      // Esperar todas los workers
      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

      long endTimee = System.currentTimeMillis();
      String totalTime = (endTimee - inicialTime) + "";

      StringBuilder resultado = new StringBuilder();
      for (CompletableFuture<String> f : futures) {
        resultado.append(f.get()).append("\n");
      }

      res = "Lista de numeros perfectos:\n\n Numero de Hilos: "+numWorkers+ "\n\n"  + resultado.toString() + "\n\ntiempo total: " + totalTime;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return res;
  }


  //Agregar mas hilos
  private int calculateOptimalWorkers(int totalRange) {
    if (totalRange <= 1000) {
      return 2;
    } else if (totalRange <= 10000) {
      return 3;
    } else if (totalRange <= 100000) {
      return 4;
    } else if (totalRange <= 200000) {
      return 5;
    } else if (totalRange <= 300000) {
      return 6;
    } else if (totalRange <= 400000) {
      return 7;
    } else if (totalRange <= 500000) {
      return 8;
    } else if (totalRange <= 600000) {
      return 9;
    }
    else {
      return MAX_CONCURRENT_TASKS;
    }
  }
}
