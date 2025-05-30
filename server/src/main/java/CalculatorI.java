import CalcNum.*;
import com.zeroc.Ice.Current;

public class CalculatorI implements CalculatorPerfectNum {


    @Override
    public String calNumber(double x, double y, Current current){

        String res = "";

        int newX = (int) x;
        int newY = (int) y;

        Worker worker = new Worker(newX , newY);
        Thread thread = new Thread(worker);
        thread.start();


        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        res = "Números perfectos encontrados: " + worker.getListOfPerfectNumbers();


        return res;

    
    }


}
