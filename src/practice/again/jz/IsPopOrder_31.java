package practice.again.jz;

import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/31 20:10
 */
public class IsPopOrder_31 {

    public static boolean IsPopOrder(int[] pushA,int[] popA) {
        // 1.边界值判断
        // 2.如果栈为空 或者 栈顶元素!= 当前指针指向的popA数组的元素 —— 将元素逐个入栈，直到遇到相等的元素为止
        // 2.1 如果pushA数组已经扫描完毕了，但是栈顶元素 != 当前指针所指向的popA数组的元素 —— 直接跳出循环
        // 3. 对最终的结果值再进行判断 —— 判断是否栈为空 或者 用于扫描popA数组的指针是否指向popA数组的末尾

        if (pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }
        if (pushA == null && popA == null) {
            return true;
        }
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        while (j < popA.length) {
            while (stack.isEmpty() || stack.peek() != popA[j]) {
                // 如果pushA数组都扫描完了，那就退出循环，在进行下一步判断
                if (i == pushA.length) {
                    break;
                }
                stack.push(pushA[i++]);// 将元素入栈，直到找到相等的元素为止
            }
            // 如果pushA数组都扫描完了，还是没找到相等的元素。退出循环，进行下一步判断
            if (stack.peek() != popA[j]) {
                break;
            }
            // 如果遇到相同的元素，就弹栈，并且 扫描popA数组的下一个元素
            stack.pop();
            j++;
        }
        // 最终判断
        if (stack.isEmpty() && j == popA.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // 测试
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        System.out.println(IsPopOrder(pushA, popA));
    }
}
