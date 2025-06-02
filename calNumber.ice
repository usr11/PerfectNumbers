module CalcNum {

  interface CalculatorPerfectNum {
    string calNumber(int x, int y);
  }

  interface Worker {
    string calcNumberInRange(int start, int end);
  }

}