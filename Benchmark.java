import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Benchmark {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(
                System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            Benchmark.matchBenchmark(line);
        }
    }

    public static void matchBenchmark(String input) {
        /* Split strings to store data appropriately */
        String portfolio = input.split(":")[0];
        String benchmark = input.split(":")[1];
        String[] splitPortfolio = portfolio.split("\\|");
        String[] splitBenchmark = benchmark.split("\\|");
        HashMap<String, Integer> pAssets = new HashMap<>();
        HashMap<String, Integer> bAssets = new HashMap<>();
        String[] pCompanyAsset = new String[splitPortfolio.length];
        String[] bCompanyAsset = new String[splitBenchmark.length];

        /* Store firm and asset as a key, and number of shares as
         a value in a HashMap */
        for (int i = 0; i < splitPortfolio.length; i++) {
            String s = splitPortfolio[i];
            pCompanyAsset[i] = s.split(",")[0] + " " + s.split(
                    ",")[1];
            pAssets.put(pCompanyAsset[i], Integer.parseInt(s.split(
                    ",")[2]));
        }

        /* Do the same for the benchmark */
        for (int i = 0; i < splitBenchmark.length; i++) {
            String s = splitBenchmark[i];
            bCompanyAsset[i] = s.split(",")[0] + " " + s.split(
                    ",")[1];
            bAssets.put(bCompanyAsset[i], Integer.parseInt(s.split(
                    ",")[2]));
        }

        for (String key : bAssets.keySet()) {
            Integer currVal = bAssets.get(key);

            /* Find the amount to buy or sell if the company-asset is shared
            between the two
            HashMaps
             */
            if (pAssets.containsKey(key)) {
                Integer currPVal = pAssets.get(key);
                int result = currVal - currPVal;
                if (result < 0) {
                    System.out.println("SELL," + key.split(
                            "\\s+")[0] + "," + key.split(
                            "\\s+")[1] + "," + Math.abs(result));
                }
                if (result > 0) {
                    System.out.println("BUY," + key.split(
                                    "\\s+")[0] + "," + key.split(
                                    "\\s+")[1] + "," + result);
                }
            } else {
                /* If company-asset is unique to benchmark HashMap, print out
                number of shares on its own as an amount to buy
                 */
                System.out.println("BUY," + key.split(
                        "\\s+")[0] + "," + key.split(
                                "\\s+")[1] + "," + currVal);
            }
        }
    }
}
