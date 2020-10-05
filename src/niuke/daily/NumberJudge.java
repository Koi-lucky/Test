package niuke.daily;

import java.util.Scanner;

public class NumberJudge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long num  = Integer.valueOf(sc.nextLine());
            for (int i = 0;i < num; i++) {
                String str = sc.nextLine();
                long num1 = Long.parseLong(str);
                int count = 0;
                int length = str.length();
                for (int j = 0; j < length; j++) {
                    int val = str.charAt(j) - 48;
                    if (num1 % val == 0) {
                        count++;
                    } else if (val == 0) {
                        count++;
                    }
                }
                judge(count, length);
            }
        }
    }

    public static void judge( int count, int length) {
        if(count == length) {
            System.out.println("G");
        } else if(count > 0) {
            System.out.println("H");
        } else {
            System.out.println("S");
        }
    }
}
