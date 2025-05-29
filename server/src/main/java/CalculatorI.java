import CalcNum.*;
import com.zeroc.Ice.Current;

public class CalculatorI implements CalculatorPerfectNum {


    @Override
    public double add(double x, double y, Current current) {
      
      try{

        Thread.sleep(5000);
      
      } catch(Exception e){
      
        //TODO: handle exception
      } 
      
      return x + y;
    
    }
    

    @Override
    public double sub(double x, double y, Current current) {
      
      try{

        Thread.sleep(5000);
      
      } catch(Exception e){
      
        //TODO: handle exception
      } 
      
      return x - y;
    
    }

}
