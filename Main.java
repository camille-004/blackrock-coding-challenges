import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;
import static java.lang.System.*;

@SuppressWarnings("ALL")
public class Main {

    /* STATIC FINAL CONSTANTS */
    static final int ONE_PENCE = 1;
    static final int TWO_PENCE = 2;
    static final int FIVE_PENCE = 5;
    static final int TEN_PENCE = 10;
    static final int TWENTY_PENCE = 20;
    static final int FIFTY_PENCE = 50;
    static final int ONE_POUND = 100;
    static final int TWO_POUNDS = 200;
    static final int FIVE_POUNDS = 500;
    static final int TEN_POUNDS = 1000;
    static final int TWENTY_POUNDS = 2000;
    static final int FIFTY_POUNDS = 5000;
    static final int CONVERT_TO_PENCE = 100;
    static final int STRING_STRIP = 2;

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader in = new BufferedReader(reader);

        try {
            double purchasePrice = Double.parseDouble(in.readLine());
            double cash = Double.parseDouble(in.readLine());
            Main.calculateChange(purchasePrice, cash);
        } catch (Exception e) {
            out.println(e);
        }
    }

    public static void calculateChange(
            double purchasePrice, double cash) {
        /* Access your code here. Feel free to create other classes as required */
        if (cash < purchasePrice) {
            /* Account for "ERROR" case */
            out.println("ERROR");
        }
        else if (cash == purchasePrice) {
            /* Account for "Zero" case */
            out.println("Zero");
        } else {
            /* Calculate the change, multiply by 100 do avoid rounding errors */
            double change = round((cash - purchasePrice) * CONVERT_TO_PENCE);

            /* Create StringBuilder for the resulting string */
            StringBuilder amounts = new StringBuilder();

            /* Calculate the number of Fifty Pounds to include in change */
            int fiftyPounds = round((int) change / FIFTY_POUNDS);
            if (fiftyPounds != 0) {
                /* Don't append to StringBuilder if not paid as change */
                amounts.append("Fifty Pounds, ".repeat(fiftyPounds));
            }
            change %= FIFTY_POUNDS;

            int twentyPounds = round((int) change / TWENTY_POUNDS);
            if (twentyPounds != 0) {
                amounts.append("Twenty Pounds, ".repeat(twentyPounds));
            }
            change %= TWENTY_POUNDS;

            int tenPounds = round((int) change / TEN_POUNDS);
            if (tenPounds != 0) {
                amounts.append("Ten Pounds, ".repeat(tenPounds));
            }
            change %= TEN_POUNDS;

            int fivePounds = round((int) change / FIVE_POUNDS);
            if (fivePounds != 0) {
                amounts.append("Five Pounds, ".repeat(fivePounds));
            }
            change %= FIVE_POUNDS;

            int twoPounds = round((int) change / TWO_POUNDS);
            change %= TWO_POUNDS;
            if (twoPounds != 0) {
                amounts.append("Two Pounds, ".repeat(twoPounds));
            }

            int onePound = round((int) change / ONE_POUND);
            change %= ONE_POUND;
            if (onePound != 0) {
                amounts.append("One Pound, ".repeat(onePound));
            }

            int fiftyPence = round((int) change / FIFTY_PENCE);
            if (fiftyPence != 0) {
                amounts.append("Fifty Pence, ".repeat(fiftyPence));
            }
            change %= FIFTY_PENCE;

            int twentyPence = round((int) change / TWENTY_PENCE);
            if (twentyPence != 0) {
                amounts.append("Twenty Pence, ".repeat(twentyPence));
            }
            change %= TWENTY_PENCE;

            int tenPence = round((int) change / TEN_PENCE);
            if (tenPence != 0) {
                amounts.append("Ten Pence, ".repeat(tenPence));
            }
            change %= TEN_PENCE;

            int fivePence = round((int) change / FIVE_PENCE);
            if (fivePence != 0) {
                amounts.append("Five Pence, ".repeat(fivePence));
            }
            change %= FIVE_PENCE;

            int twoPence = round((int) change / TWO_PENCE);
            if (twoPence != 0) {
                amounts.append("Two Pence, ".repeat(twoPence));
            }
            change %= TWO_PENCE;

            int onePence = round((int) change / ONE_PENCE);
            if (onePence != 0) {
                amounts.append("One Pence, ".repeat(onePence));
            }
            change %= ONE_PENCE;

            String finalString = amounts.toString();
            out.println(finalString.substring(
                    0, finalString.length() - STRING_STRIP));
        }
    }
}
