import java.util.ArrayList;
import java.util.List;
import CalcNum.*;
import com.zeroc.Ice.Current;

public class WorkerI implements Worker{

  @Override
  public String calcNumberInRange(int start, int end, Current current){

    List<Integer> listOfPerfectNumbers = new ArrayList<>();;

    System.out.println("Trabajando...");

    for (int n = start; n < end; n++) {
      long sum = 0;
      for (int i = 1; i <= n / 2; i++) {
        if (n % i == 0) {
          sum += i;
        }
      }
      if (sum == n) {
        listOfPerfectNumbers.add(n);
      }
    }

    return "Lista: " + listOfPerfectNumbers;
  }


}
