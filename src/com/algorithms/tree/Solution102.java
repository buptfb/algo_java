package com.algorithms.tree;

import java.util.*;

/**
 * 自顶向下层次遍历二叉树
 * @author fanbo@imoran.net
 * @date 2021/1/15 5:24
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        levelOrder(root, 0, ret);
        return ret;

    }

    private void levelOrder(TreeNode node, int level, List<List<Integer>> result){
        if (node == null) {
            return;
        }
        if(result.size() == level){
            result.add(new ArrayList<>());
        }

        List<Integer> levelList = result.get(level);
        levelList.add(node.val);

        if (node.left != null) {
            levelOrder(node.left, level + 1, result);
        }
        if (node.right != null) {
            levelOrder(node.right, level + 1, result);
        }
    }



        public static void main(String[] args) {
        Solution102 sln = new Solution102();
        // 根据给定的数组创建一棵树ion
        TreeNode root = ConstructTree.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        // 将刚刚创建的树打印出来
        TreeOperation.show(root);

        List<List<Integer>> result = sln.levelOrder(root);
        System.out.println("########################################################");
        for (List<Integer> oneLevel : result) {
            for (Integer element : oneLevel) {
                System.out.print(element + ",");
            }
            System.out.println("");
        }

            List<List<Integer>> result2 = sln.levelOrderRecursive(root);
            System.out.println("########################################################");
            for (List<Integer> oneLevel : result2) {
                for (Integer element : oneLevel) {
                    System.out.print(element + ",");
                }
                System.out.println("");
            }
    }
}
