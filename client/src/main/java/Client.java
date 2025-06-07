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
      
      
      while (option != 3) {
        
        int workers = -1;

        System.out.println("\n\n1. Para ingresar un rango y que el numero de workers se establezcan.");
        System.out.println("2. Para ingresar un rango y un numero de trabajadores especifico (De 1 a 20).");
        System.out.println("3. Para salir.");

        option = sc.nextInt();

        switch (option) {
          case 1:
          
            System.out.println("Ingresa el primer numero:");
            start = sc.nextInt();
            System.out.println("Ingresa el segundo numero:");
            end = sc.nextInt();
            System.out.println("Llamando a la operacion: ");
            System.out.println(calculatorPerfectNum.calNumber(start, end+1, workers));
            break;
          
          case 2:
            
            System.out.println("Ingresa el numero de trabajadores: ");
            workers = sc.nextInt();
            System.out.println("Ingresa el primer numero:");
            start = sc.nextInt();
            System.out.println("Ingresa el segundo numero:");
            end = sc.nextInt();
            System.out.println("Llamando a la operacion: ");
            System.out.println(calculatorPerfectNum.calNumber(start, end+1, workers));
            break;
          
          case 3:
          
            System.out.println("Chaooo.");

            break;
        
          default:
            System.out.println("Opcion no valida.");
            break;
        }
        
      }
      
      

    }
  }
}
