import java.io.*;

public class MakingAnagram {
    public static int makingAnagrams(String s1, String s2) {
        // Write your code here
        int[] freq = new int[26];

        for(int ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(int ch : s2.toCharArray()) {
            freq[ch - 'a']--;
        }
        int delete = 0;
        for(int i = 0 ; i < freq.length ; i++) {
            delete += Math.abs(freq[i]);
        }
        return delete;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
