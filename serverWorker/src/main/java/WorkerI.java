import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import CalcNum.*;
import com.zeroc.Ice.Current;

public class WorkerI implements Worker {

    private static final Logger logger = Logger.getLogger(WorkerI.class.getName());

    @Override
    public String calcNumberInRange(int start, int end, Current current) {

        String res = "N/N";

        List<Integer> listOfPerfectNumbers = new ArrayList<>();
        int total = end - start;
        int lastLoggedPercent = -10; 

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

            // Progreso
            int currentProgress = n - start + 1;
            int percent = (int) ((currentProgress * 100.0) / total);

            if (percent >= lastLoggedPercent + 10 || percent == 100) {
                lastLoggedPercent = percent;
                String bar = generateProgressBar(percent);
                logger.info("⏳ Progreso del rango [ "+start+", "+end+"]: " + bar + " " + percent + "%");
            }
        }

        if (!listOfPerfectNumbers.isEmpty()) {
            res = "" + listOfPerfectNumbers;
        }

        return res;
    }

    private String generateProgressBar(int percent) {
        int totalBlocks = 40;
        int filledBlocks = (percent * totalBlocks) / 100;
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < totalBlocks; i++) {
            if (i < filledBlocks) {
                bar.append("=");
            } else if (i == filledBlocks) {
                bar.append(">");
            } else {
                bar.append(" ");
            }
        }
        bar.append("]");
        return bar.toString();
    }
}

