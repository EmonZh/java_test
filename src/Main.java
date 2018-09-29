import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.*;

public class Main implements Cloneable {

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    private String s1, s2;

    public int getZzz() {
        return zzz;
    }

    private final int zzz = 123;

    public Main() {}

    public void readData() {
        Scanner input = new Scanner(in);
        int n = input.nextInt();
        s1 = input.next();
        s2 = input.next();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void solveProblem() {
        int sum = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (i + 1 < s1.length()) {
                    if (s1.charAt(i + 1) != s2.charAt(i + 1) && s1.charAt(i) == s2.charAt(i + 1)) {
                        i += 1;
                    }
                }
                sum += 1;
            }
        }
        out.println(sum);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Main helper = new Main();
        helper.setS1("ABC");
        Main helper2 = (Main) helper.clone();
        helper2.setS1("AAA");
        out.println(helper2.getS1());

        //helper.readData();
        //helper.solveProblem();
    }
}