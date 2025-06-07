module CalcNum {

  interface CalculatorPerfectNum {
    string calNumber(int x, int y, int workers);
  }

  interface Worker {
    string calcNumberInRange(int start, int end);
  }

}