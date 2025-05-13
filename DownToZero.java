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
     * Complete the 'downToZero' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int downToZero(int n) {

        if (n == 0) return 0;

        boolean[] visit = new boolean[n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, 0});
        visit[n] = true;

        while (!q.isEmpty()) {
            int[] state = q.poll();
            int curr = state[0];
            int steps = state[1];

            if (curr == 0){
                return steps;
            }

            if (!visit[curr - 1]) {
                visit[curr - 1] = true;
                q.offer(new int[]{curr - 1, steps + 1});
            }
            for (int i = 2 ; i <= Math.sqrt(curr) ; i++) {
                if (curr % i == 0) {
                    int next = Math.max(i, curr / i);
                    if (!visit[next]) {
                        visit[next] = true;
                        q.offer(new int[]{next, steps + 1});
                    }
                }
            }
        }

        return -1;
    }
}

public class DownToZero {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.downToZero(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
