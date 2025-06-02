import CalcNum.*;
import com.zeroc.Ice.*;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Client {
  public static void main(String[] args) throws java.lang.Exception {

    Scanner sc = new Scanner(System.in);

    try (Communicator communicator = Util.initialize(args, "client.config")) {
      ObjectPrx base = communicator.propertyToProxy("serverMaster.proxy");
      CalculatorPerfectNumPrx calculatorPerfectNum = CalculatorPerfectNumPrx.checkedCast(base);

      if (calculatorPerfectNum == null) {
      
        throw new Error("Proxy nulo - ¿Se pudo conectar al servidor?");
      
      }

      int option = 0;
      int start = 0;
      int end = 0;


      System.out.println("Bienvenido!!! Aqui podras calcular numeros perfectos en un rango de manera eficiente: ");


      while (option != 2) {

        System.out.println("1. Para ingresar un rango.");
        System.out.println("2. Para salir.");

        option = sc.nextInt();

        switch (option) {
          case 1:
            System.out.println("Ingresa el primer numero:");
            start = sc.nextInt();
            System.out.println("Ingresa el segundo numero:");
            end = sc.nextInt();
            System.out.println("Llamando a la operacion: ");
            System.out.println(calculatorPerfectNum.calNumber(start, end));
            break;
        
          default:
            System.out.println("Chaooo.");
            break;
        }
        
      }
      
      

    }
  }
}
