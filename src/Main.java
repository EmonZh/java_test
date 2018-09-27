import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    private int[] num;
    private HashMap<Integer, Integer> hashtable;
    private int gcd(int x, int y) {
        if (x == 0)
            return y;
        return this.gcd(y % x, x);
    }

    public void readData() throws IOException {
        Scanner input = new Scanner(in);
        int n = input.nextInt();
        num = new int[n];
        hashtable = new HashMap<>();
        String s = new String();
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            s = input.next();
            for (int j = 0; j < 26; ++j)
                cnt[j] = 0;
            for (int j = 0; j < s.length(); ++j) {
                cnt[s.charAt(j) - 'a'] ^= 1;
            }
            num[i] = 0;
            for (int j = 0; j < 26; ++j)
                if (cnt[j] > 0)
                    num[i] |= (1 << j);
        }
    }

    private int getHashCnt(int x) {
        if (hashtable.containsKey(x))
            return hashtable.get(x);
        return 0;
    }

    private void putHashKey(int x) {
        if (hashtable.containsKey(x))
            hashtable.replace(x, hashtable.get(x) + 1);
        else
            hashtable.put(x, 1);
    }

    public void solveProblem() {
        long sum = 0;
        for (int i = 0; i < num.length; ++i) {
            sum += getHashCnt(num[i]);
            for (int j = 0; j < 26; ++j) {
                sum += getHashCnt(num[i] ^ (1 << j));
            }
            putHashKey(num[i]);
        }
        out.println(sum);
    }

    public static void main(String[] args) throws  IOException {
        Main helper = new Main();
        helper.readData();
        helper.solveProblem();
    }
}