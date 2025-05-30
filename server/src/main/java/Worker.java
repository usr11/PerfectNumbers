import java.util.ArrayList;
import java.util.List;

public class Worker implements Runnable{

    private int start;
    private int end;
    private List<Integer> listOfPerfectNumbers;

    public Worker(int start, int end){
        this.start = start;
        this.end = end;
        this.listOfPerfectNumbers = new ArrayList<>();
    }

    @Override
    public void run(){
        System.out.println("Trabajando...");
        for (int i = start; i < end; i++) {
            int num = (int) calNumber(i);
            if(num != 0){
                listOfPerfectNumbers.add(num);
            }
        }

    }



    public double calNumber(double n) {

        double res = 0;
        double primeSection = Math.pow(2, n) - 1 ;
        boolean isPrimePrimeSection = isPrime(primeSection);

        if(isPrimePrimeSection){
            res = Math.pow(2, (n-1))*primeSection;
        }

        return res;

    }


    public boolean isPrime(double n){

        double mid = (int) n/2;
        int cont = 0;
        boolean result = false;

        for (int i = 1; i < mid+1; i++) {
            if(n % i == 0){
                cont++;
            }
        }

        if(cont == 1) {
            result = true;
        }

        return result;
    }


    public List<Integer> getListOfPerfectNumbers() {
        return listOfPerfectNumbers;
    }

}
