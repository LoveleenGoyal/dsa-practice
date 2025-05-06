import java.io.*;

public class CommonChild {
    public static int commonChild(String s1, String s2) {

        int[][] dp = new int[s1.length()][s2.length()];
        for(int i = 0 ; i < s1.length() ; i++) {
            for(int j = 0 ; j < s2.length() ; j++) {
                dp[i][j] = -1;
            }
        }

        return lcs(s1, s2, 0, 0, dp);
    }
    public static int lcs(String s1, String s2, int i, int j, int[][] dp) {
        if(i == s1.length() || j== s2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + lcs(s1, s2, i+1, j+1,dp);
        }
        else{
            dp[i][j] = Math.max(lcs(s1, s2, i+1, j, dp),lcs(s1, s2, i, j+1, dp));
        }
        return dp[i][j];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
