package com.algorithms.tree;

/**
 * @author fanbo@imoran.net
 * @date 2021/1/5 13:36
 */
public class TreeOperationTest {
    public static void main(String[] args) {
        // 根据给定的数组创建一棵树ion
        TreeNode root = ConstructTree.constructTree(new Integer[] {1, 2, 3, 4, 5 ,6, 7});
        // 将刚刚创建的树打印出来
        TreeOperation.show(root);
    }
}
