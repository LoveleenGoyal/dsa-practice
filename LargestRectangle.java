import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {
        // Write your code here
        long max = 0L;
        int n = h.size();
        for(int i = 0 ; i < n ; i++) {
            long height = h.get(i);

            int left = i;
            for(int j = i-1 ; j>= 0 ; j--) {
                if(h.get(j) >= height) {
                    left = j;
                }else {
                    break;
                }
            }

            int right = i;
            for(int j = i+1 ; j < n ; j++) {
                if(h.get(j) >= height) {
                    right = j;
                }else {
                    break;
                }
            }
            long width = right - left + 1;
            long area = height * width;
            if(area > max) {
                max = area;
            }
        }
        return max;
    }
}

public class LargestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
