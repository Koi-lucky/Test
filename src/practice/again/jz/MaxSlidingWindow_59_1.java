package practice.again.jz;

import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/2 22:48
 */
public class MaxSlidingWindow_59_1 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 单调队列实现
        // 1.队列内仅仅包含窗口内的元素 —— 每轮窗口滑动移除元素nums[i-1]，需要将队列内对应的元素一起删除
        // 2.队列内的元素非严格递减 —— 每轮窗口滑动添加了元素nums[j+1],需要将队列内所有小于nums[j+1]的元素都删除掉

        // 特殊边界值判断
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        // 创建一个数组用于存储每个滑动窗口的最大值
        int[] arr = new int[nums.length - k + 1];
        int index = 0;// arr数组的下标索引
        // 1.没有形成窗口时 —— 保持队列内的元素从大到小的顺序【非严格递减的顺序】
        for (int i = 0; i < k; i++) {
            // 当队列不为空时，拿当前元素 与 对尾元素 进行比较。如果大于队尾元素，就删除队尾的元素
            // 一直进行循环删除，直到队列中的所有值都大于当前值，或者队列为空
            // 再将当前值加入到队列中
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        // 将窗口形成时的队列的最大值放入到arr数组中存储（也就是将队列头部元素加入到arr数组中）
        // 因为下边的代码逻辑是从窗口滑动开始的（第二个窗口开始），第一个窗口必须手动进行添加
        arr[index++] = deque.peekFirst();

        // 2.已经形成窗口了 —— 开始进行滑动
        for (int i = k; i < nums.length; i++) {
            // 此时是从第二个窗口开始的，所以要移除窗口的第一个元素
            // 窗口的第一个元素是nums[i-k],因为此时i-k是上一个窗口的第一个元素
            // 判断队列首部元素是不是nums[i-k]，如果是则直接移除
            if (nums[i - k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            // 删除队列中比当前值小的所有元素，再把当前值加入到队列中
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            // 再把新窗口的队首元素加入到arr数组中
            arr[index++] = deque.peekFirst();
        }
        return arr;
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(maxSlidingWindow(nums, k));
    }
}
