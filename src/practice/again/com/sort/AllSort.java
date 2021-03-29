package practice.again.com.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/7 8:31
 */
public class AllSort {

    // ① 冒泡排序
    public void bubbleSort(int[] arr) {
        // 设置一个标志位，
        // 如果排序了就将标志位置1，
        // 如果未进行排序，直接跳出循环不用进行后面的无效循环
        boolean flag = false;
        for (int i = 0; i < arr.length - 1 && !flag; i++) {
            flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    swapData(arr[j], arr[j + 1]);
                }
            }
        }
    }

    // ② 选择排序
    public void selictionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 设置一个临时变量，用于存储当前最小值的下标
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j ] < arr[i]) {
                    min = j;
                }
            }
            // 将后面数组的最小值不断往前挪
            swapData(arr[min], arr[i]);
        }
    }

    // ③ 插入排序
    public void insertionSort(int[] arr) {
        // 每次拿未排序数组的第一个元素逐个与 前面已排好序的数组进行比较（从后往前比较）
        for (int i = 1; i < arr.length; i++) {
            // 需要反复的把已经排好序的数组不断后移
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swapData(arr[j], arr[j - 1]);
                }
            }
        }
    }

    // ④ 希尔排序
    public void shellSort(int[] arr) {
        // 间隔排序
        // 每次必须动态的划分间隔，再进行逐个排序
        int grap = 1;// 间隔初始化为1
        // 动态的定义间隔序列
        while (grap < arr.length / 3) {
            grap = grap * 3 + 1;
        }
        // 间隔排序
        while (grap >= 1) {
            for (int i = grap; i < arr.length; i++) {
                for (int j = i; j >= grap; j -= grap) {
                    if (arr[j] < arr[j - grap]) {
                        swapData(arr[j], arr[j - grap]);
                    }
                }
            }
            // 更新间隔的值
            grap /= 3;
        }
    }

    // ⑤ 归并排序
    // 1.分+合
    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        // 递归思路
        if (left < right) {
            // 取中间值
            int mid = left + (right - left) / 2;
            // 向左递归，进行分解
            mergeSort(arr, left, mid, temp);
            // 向右递归，进行分解
            mergeSort(arr, mid + 1, right, temp);
            // 将左递归，和右递归进行合并
            merge(arr, left, mid, right, temp);
        }
    }
    // 2.合
    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 将两个已经排好序的数组，进行合并 —— 也就是将两个已经排好序的数组，合并成一个有序数组
        // 从两个数组的首部开始，取二者最小值放于temp数组中
        // 最终判断两个数组是否还有值剩余，如果有，就将剩余的数全部加到temp数组的最后
        int i = left, j = mid + 1;// 两个已排序数组的索引值
        int t = 0;// temp数组的索引值
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        // 最后将temp数组中的数拷贝到arr数组中（并不是拷贝所有的数）
        int tempLeft = left;// 定义一个临时变量用于存储左边数组的索引值
        t = 0;// 将temp数组的索引重新置0，以便后续的拷贝遍历
        // 第一次合并：tempLeft=0,right=1;第二次合并tempLeft=2,right=3;第三次合并：tempLeft=0,right=3
        // 合并完左边数组之后，再合并右边的数组
        // 最后一次合并完之后：tempLeft=0,right=7（假设一共7个测试数据）
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

    // ⑥ 快速排序
    public void quickSort(int[] arr, int left, int right) {
        // 将所有的数都按照规则排序 —— mid左边的数都小于他，mid右边的数都大于他
        int l = left, r = right;
        int mid = left + (right - left) / 2;
        while (l < r) {
            // 找到左边第一个 大于 mid 的数
            while (arr[l] < arr[mid]) {
                l++;
            }
            // 找到右边第一个 小于 mid 的数
            while (arr[r] > arr[mid]) {
                r--;
            }
            // 交换两个数
            swapData(arr[l], arr[r]);
            // 交换完之后，再进行判断
            if (arr[l] == arr[mid]) {
                l++;
            }
            if (arr[r] == arr[mid]) {
                r--;
            }
        }
        // 循环结束后，如果l==r，就需要将两个指针错开，以防栈溢出
        if (l == r) {
            l++;
            r--;
        }
        // 向左边继续递归进行排序
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 向右边继续进行递归排序
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    // ⑦ 堆排序
    public void heapSort(int[] arr) {
        // 1.构建一个大顶堆
        buildMaxHeap(arr);
        // 2.调整，使之成为一个大顶堆
        // 3.循环将堆首位（最大值）与末位交换，然后再重新调整最大堆
        // 将堆顶元素“沉”到堆底，再进行重新调整
        for (int j = arr.length - 1; j >= 0; j--) {
            // 交换
            swapData(arr[0], arr[j]);
            // 调整
            adjustHeap(arr,0,j);// 每次调整的长度都在减小
        }
    }
    // 1.构造一个最大堆
    public void buildMaxHeap(int[] arr) {
        // 从最后一个非叶子节点开始，向上构造大顶堆
        // i的左子树、右子树分别为：2*i+1，2*i+2
        for (int i = arr.length / 2 - 1;i >= 0; i--) {
            adjustHeap(arr,i, arr.length);
        }
    }
    // 2.调整，使之成为一个大顶堆
    public void adjustHeap(int[] arr, int i, int len) {
        // 先取出当前元素，保存在临时变量中
        int temp = arr[i];
        // 从i的左子结点开始：2*i+1
        for (int j = 2 * i + 1; j < len; j = 2 * j + 1) {
            // 如果左子结点的值 < 右子节点的值，将指针后移至右节点的位置
            if (j + 1 < len && arr[j] < arr[j + 1]) {
                j++;
            }
            // 如果该节点的值 > 父节点的值，进行交换
            if (arr[j] > temp) {
                arr[i] = arr[j];// 把较大值赋给当前节点
                i = j;// 将i指向j，继续进行循环比较
            } else {
                break;
            }
        }
        // 待循环结束后，我们已经将以i为父节点的子树的最大值 移动至 该树的最顶端
        // 最后将temp的值 放在调整后的位置
        arr[i] = temp;
    }

    // ⑧ 计数排序 —— 利用元素下标记录元素的正确位置
    /**
     * 计数排序需要根据原始数列的取值范围，创建一个统计数组，用来统计原始数列中每一个可能的整数值所出现的次数。
     * 原始数列中的整数值，和统计数组的下标是一一对应的，以数列的最小值作为偏移量。
     * 比如原始数列的最小值是90， 那么整数95对应的统计数组下标就是 95-90 = 5。
     * */
    @Test
    public void countingSort() {
        int[] arr = {2,2,5,8,3,1,8,5,1,3,9,6,4,5};
        if (arr.length == 0) {
            return;
        }
        // 1.找出待排序数组中的最大值与最小值 —— 确定temp数组的大小max - min + 1
        int max = arr[0], min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // 根据两者的差来确定计数数组的长度,而不是max+1（防止空间浪费）
        int[] temp = new int[max - min + 1];
        Arrays.fill(temp, 0);
        // 2.统计待排序数组中，每个值为i的元素出现的次数，存入temp数组的第i项
        // 3.对所有的计数累加（也就是统计一共有多少个数）
        for (int i = 0; i < arr.length; i++) {
            // arr中的元素要 减去 最小值，在作为新的索引值
            temp[arr[i] - min]++;
        }
        // 4.反向填充目标数组 —— 将每个元素i放在数组arr的第arr[i]项，每放一个元素就将temp[i]--
        int index = 0;// 创建结果数组的索引
        // 遍历temp数组，将计数数组的索引值填充到结果数组中
        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > 0) {
                // 再将减掉的最小值补上
                arr[index++] = i + min;
                temp[i]--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // ⑨ 桶排序 —— 当数列取值过大 或者 不是整数时，不能使用计数排序，可以使用桶排序
    public void bucketSort(int[] arr) {
        // 1.创建桶，并且确定每一个桶的区间范围
        // 计算最大值与最小值
        int max = arr[0], min = arr[0];
        for (int val: arr) {
            max = Math.max(val,max);
            min = Math.min(val,min);
        }
        // 计算桶的数量
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            list.add(new ArrayList<>());
        }
        // 2.遍历原始数组，将各个元素对号入座放入桶中
        for (int value: arr) {
            int num = (value - min) / arr.length;
            list.get(num).add(value);// 链式编程 —— 找到num所在的桶，并将其连在桶的末尾
        }
        // 3.每个桶内部的元素分别进行排序（可以用不同的排序方法，也可以用递归桶排序）
        for (int i = 0; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }
        // 4.遍历所有不为空的桶，并将他们中的元素串在一起，就是排序好的数组了
        int index = 0;// 遍历结果数组的索引
        for (int i = 0; i < list.size();i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                arr[index++] = list.get(i).get(j);
            }
        }
    }

    // ⑩ 基数排序 —— 桶排序的扩展
    /**
     * 1.判断待排序数列的整数的位数（假设此处最多只有两位数的整数）
     * 2.根据个位数值放入对应的桶中
     * 3.将桶中的元素按顺序赋值到原始数组中去
     * 4.再根据十位数值将数据放入对应的桶中去
     * 5.在将桶中的元素复制到原始数据中
     * 6....（直到整数的最高位也排序完）
     * 7.完成排序
     * */
    public void radixSort(int[] arr, int left, int right, int digit) {
        // 定义10个数列（0~9）
        final int radix = 10;
        int i = 0, j = 0;
        int[] count = new int[radix];// 计数数组
        int[] bucket = new int[right - left + 1];// 临时数组，用于存储每次遍历后的数列
        // 依次遍历每一个位数(个位、十位、百位、千位......)
        for (int d = 1; d <= digit; d++) {
            // 每个数列初始化
            for (i = 0; i < radix; i++) {
                count[i] = 0;
            }
            // 统计每个序列对应的元素数量
            for (i = left; i <= right; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            // 计算位置
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            // 记录到对应的位置
            for (i = right; i >= left; i --) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];// 数组下标从0开始
                count[j]--;
            }
            for (i = left, j = 0; i <= right; i++,j++) {
                arr[i] = bucket[j];
            }
        }

    }
    // 计算最大位数
    public int maxBits(int[] arr) {
        int max = arr[0];
        for (int val: arr) {
            max = Math.max(max,val);
        }
        int res = 0;// 表示最大位数
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }
    // 获取该整数的位数数值
    public int getDigit(int x, int d) {
        return ((x / ((int)Math.pow(10, d - 1))) % 10);
    }

    // 交换数据操作
    public void swapData(int num1, int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
}
