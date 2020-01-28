import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static Map<Integer, Integer> socksMap = new HashMap<Integer, Integer>(); // sockcolor, count

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        // Fill the socksMap to store the counter of each color
        for(int i = 0; i < n; i++) {
            if (socksMap.containsKey(ar[i])) {
                int counter = socksMap.get(ar[i]);
                counter += 1;
                socksMap.put(ar[i], counter);
            } else {
                socksMap.put(ar[i], 1);
            }
        }
        int noOfPairs = 0;
        Set<Map.Entry<Integer, Integer>> row = socksMap.entrySet();
        // Return the number of pair
        for (Map.Entry<Integer, Integer> data: row) {
            int value = data.getValue();
            int pair = value / 2;
            noOfPairs += pair;
        }
        return noOfPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
