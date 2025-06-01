import CalcNum.*;
import com.zeroc.Ice.*;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Client {
  public static void main(String[] args) throws java.lang.Exception {

    Scanner sc = new Scanner(System.in);

    try (Communicator communicator = Util.initialize(args, "client.config")) {
      ObjectPrx base = communicator.propertyToProxy("server.proxy");
      CalculatorPerfectNumPrx calculatorPerfectNum = CalculatorPerfectNumPrx.checkedCast(base);

      if (calculatorPerfectNum == null) {
        throw new Error("Proxy nulo - ¿Se pudo conectar al servidor?");
      }

      double x = 8000;
      double y = 10000;

      // Realizar algunas operaciones de cálculo
      System.out.println("Llamando a la operacion: ");

      System.out.println(calculatorPerfectNum.calNumber(x, y));

    }
  }
}
