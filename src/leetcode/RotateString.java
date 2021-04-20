package leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/20 21:18
 */
public class RotateString {

    public static boolean rotateString(String A, String B) {
        // 边界值判断
        if(A.length() != B.length())  return false;
        if(A.length() == 0)  return true;
        // 只有当A的长度等于B的长度并且 A 能在两个 B 的中间时，B才能通过自旋得到A
        B += B;
        // 遍历新的B，找到A字符串第一个字符在B中的位置，进行切分再依次扫描比较
        for(int i = 0; i < B.length(); i++){
            // 找到A首字符在B中的位置
            if(B.charAt(i) == A.charAt(0)){
                // 找到之后逐个扫描A
                int k = i + 1;
                for(int j = 1; j < A.length() && k < B.length(); j++){
                    if(A.charAt(j) != B.charAt(k)){
                        break;
                    }
                    k++;
                }
                if(k == i + A.length()){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        // 测试
        /*String A = "abcde";
        String B = "abced";*/
        String A = "abcde";
        String B = "cdeab";
        System.out.println(rotateString(A, B));
    }
}
