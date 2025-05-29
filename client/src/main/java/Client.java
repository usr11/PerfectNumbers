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

          int option = 0;

          while (option != 5) {

            System.out.println("Seleccione: ");
            System.out.println("1) Suma ");
            System.out.println("2) Resta ");

            
            option = sc.nextInt();
            
            double x = 0;
            double y = 0;

            if(option != 5) {

              System.out.println("Ingrese el primer numero:");
              x = sc.nextInt();
              
              System.out.println("Ingrese el segundo numero:");
              y = sc.nextInt();
              
              // Realizar algunas operaciones de cálculo
              System.out.println("Llamando a la operacion: ");
              
            }
            
            switch (option) {
              
              case 1:
                CompletableFuture<Double> response = calculatorPerfectNum.addAsync(x, y);
                Double r = response.get();
                System.out.println("Resultado: " + r);
              
                break;
              case 2:
                System.out.println("Resultado: " + calculatorPerfectNum.sub(x, y));
                
                break;

              default:
                System.out.println("Opcion no valida");
                
                break;
                
            }
              
          }
          //TODO: llamado a otros metodos
			
			
        }
    }
}
