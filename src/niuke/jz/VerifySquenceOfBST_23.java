package niuke.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/15 10:51
 */
public class VerifySquenceOfBST_23 {

    int[] sequence = {4,8,6,12,16,14,10};

    @Test
    public void VerifySquenceOfBST() {
        // 特殊情况判断
        if (sequence == null || sequence.length <= 0) {
            System.out.println(false);
        }
        System.out.println(isBST(sequence, 0, sequence.length - 1));
    }

    // 构造一个函数，判断所给的序列 能不能 构造一颗子树
    public boolean isBST(int[] sequence, int beginIndex, int endIndex) {
        if (beginIndex >= endIndex) {
            return true;
        }
        // 1.找根节点 —— 后序遍历的序列中，最后一个结点为该树的根节点
        int root = sequence[endIndex];
        // 2.找左子树 —— 左子树的节点均小于根节点
        int index = beginIndex;// 找到左子树的最后一个结点做分割左右子树数组的节点
        while (index < endIndex && sequence[index] < root) {
            index++;
        }
        // 3.找右子树 —— 右子树的节点均大于根节点
        int index2 = index;
        while (index2 < endIndex) {
            if (sequence[index2] < root) {// BST中右子树节点的值都大于根结点的值
                return false;
            }
            index2++;
        }
        // 4.递归判断左子树是不是BST
        // 5.递归判断右子树是不是BST
        return isBST( sequence, beginIndex, index - 1) && isBST( sequence, index + 1, endIndex - 1);
    }
}
