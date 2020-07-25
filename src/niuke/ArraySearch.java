package niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1.输入数组的个数
        String num1 = sc.nextLine();
        // 2.输入数组
        String s1 = sc.nextLine();
        // 3.输入要判断的数的个数
        String num2 = sc.nextLine();
        // 4.输入要判断的数
        String s2 = sc.nextLine();

        String[] str1 = s1.trim().split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str1.length; i++) {
            list.add(str1[i].trim());
        }

        String[] str2 = s2.trim().split(" ");
        // 5.将要判断的数逐个拿出来，在原数组中进行二分查找
        for (int i = 0; i < str2.length; i++) {
            //每取一个数，判断一下原数组里有没有
            if( list.contains(str2[i].trim())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }


        // 关闭sc
        sc.close();
    }
}
