import CalcNum.*;
import com.zeroc.Ice.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws java.lang.Exception {

        Scanner sc = new Scanner(System.in);

        try (Communicator communicator = Util.initialize(args, "client.config")) {
            ObjectPrx base = communicator.propertyToProxy("serverMaster.proxy");
            CalculatorPerfectNumPrx calculatorPerfectNum = CalculatorPerfectNumPrx.checkedCast(base);

            if (calculatorPerfectNum == null) {
                throw new Error("Null proxy - could not connect to the master server.");
            }

            int option = 0;
            int start = 0;
            int end = 0;

            System.out.println("Welcome! This program finds perfect numbers in a range efficiently:");

            while (option != 3) {
                int workers = -1;

                System.out.println("\n1. Enter a range with default number of workers.");
                System.out.println("2. Enter a range and a specific number of workers (1 to 20).");
                System.out.println("3. Exit.");

                option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Enter the start number:");
                        start = sc.nextInt();
                        System.out.println("Enter the end number:");
                        end = sc.nextInt();
                        System.out.println("Calling the operation:");
                        System.out.println(calculatorPerfectNum.calNumber(start, end + 1, workers));
                        break;

                    case 2:
                        System.out.println("Enter the number of workers:");
                        workers = sc.nextInt();
                        System.out.println("Enter the start number:");
                        start = sc.nextInt();
                        System.out.println("Enter the end number:");
                        end = sc.nextInt();
                        System.out.println("Calling the operation:");
                        System.out.println(calculatorPerfectNum.calNumber(start, end + 1, workers));
                        break;

                    case 3:
                        System.out.println("Goodbye.");
                        break;

                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }
        }
    }

    public static String findPerfectNumbers(int start, int end, int workers) {
        StringBuilder result = new StringBuilder();

        try (Communicator communicator = Util.initialize(new String[]{}, "client.config")) {
            ObjectPrx base = communicator.propertyToProxy("serverMaster.proxy");
            CalculatorPerfectNumPrx calculatorPerfectNum = CalculatorPerfectNumPrx.checkedCast(base);

            if (calculatorPerfectNum == null) {
                return "Could not connect to the master server.";
            }

            result.append(calculatorPerfectNum.calNumber(start, end + 1, workers));
        } catch (com.zeroc.Ice.Exception e) {
            return "Communication error with ICE: " + e.getMessage();
        }
        return result.toString();
    }

    public static String findPerfectNumbers(int start, int end) {
        return findPerfectNumbers(start, end, -1);
    }
}
