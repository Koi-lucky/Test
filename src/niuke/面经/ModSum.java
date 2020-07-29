package niuke.面经;

import java.util.Scanner;

public class ModSum {

    public static void main(String[] args) {
        //输入两行数，第一行正整数n，第二行为n个正整数
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        int sum = 0;

        String[] str = num2.trim().split(" ");
        for (int i = 0; i < str.length; i++) {
            sum += Integer.parseInt(str[i]);//求个位数的和
        }
        System.out.println( sum - Integer.parseInt(num1));
    }
}
