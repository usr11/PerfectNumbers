module CalcNum {

  interface CalculatorPerfectNum {
    string calNumber(double x, double y);
  }

  interface Worker {
    string calcNumberInRange(int start, int end);
  }

}