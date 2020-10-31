package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizedCollection_381 {


    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedCollection_381() {
        list = new ArrayList<Integer>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (list.contains(val)) {
            list.add(val);
            return false;
        } else {
            list.add(val);
        }
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (list.contains(val)) {
            int vals = list.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection_381 collection = new RandomizedCollection_381();

// 向集合中插入 1 。返回 true 表示集合不包含 1 。
        System.out.println(collection.insert(1));

// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
        System.out.println(collection.insert(1));

// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
        System.out.println(collection.insert(2));

// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
        System.out.println(collection.getRandom());

// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
        System.out.println(collection.remove(1));

// getRandom 应有相同概率返回 1 和 2 。
        System.out.println(collection.getRandom());

    }
}
