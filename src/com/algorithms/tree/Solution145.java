package com.algorithms.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author fanbo@imoran.net
 * @date 2021/1/9 12:21
 */
public class Solution145 {

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
    }


    public static void main(String[] args) {
        Solution145 sln = new Solution145();
        // 根据给定的数组创建一棵树ion
        TreeNode root = ConstructTree.constructTree(new Integer[]{1, 2, 3, 4, 5, 6});
        // 将刚刚创建的树打印出来
        TreeOperation.show(root);

        List<Integer> result = sln.postorderTraversalRecursive(root);
        System.out.println("########################################################");
        for (Integer integer : result) {
            System.out.print(integer + ",");
        }

        List<Integer> result2 = sln.postrderTraversalIterate(root);
        System.out.println("\n########################################################");
        for (Integer integer : result2) {
            System.out.print(integer + ",");
        }

        List<Integer> result3 = sln.postrderTraversalIterate2(root);
        System.out.println("\n########################################################");
        for (Integer integer : result3) {
            System.out.print(integer + ",");
        }
    }

    private List<Integer> postrderTraversalIterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.peek();
            stack.pop();
            res.add(tmp.val);

            if (tmp.left != null) {
                stack.push(tmp.left);
            }

            if (tmp.right != null) {
                stack.push(tmp.right);
            }

        }
        Collections.reverse(res);
        return res;
    }

    private List<Integer> postrderTraversalIterate2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode lastAddToResult = root;
        while (!stack.isEmpty()) {
            // 取出栈顶元素判断, 如果当前栈顶节点是叶子节点，
            // 或者当前节点的左子节点不是上一个被遍历完成的结点，
            // 或者当前节点的右子节点不是上一个被遍历完成的结点， 那么就加入结果列表中，
            // 同时将当前栈顶元素弹出， 并更新上一个被遍历完成的节点指针
            TreeNode currentNode = stack.peek();
            if ((null == currentNode.left && null == currentNode.right)
                    || lastAddToResult == currentNode.left
                    || lastAddToResult == currentNode.right) {
                res.add(currentNode.val);
                stack.pop();
                lastAddToResult = currentNode;
            } else {
                if(currentNode.right != null){
                    stack.push(currentNode.right);
                }
                if(currentNode.left != null){
                    stack.push(currentNode.left);
                }
            }
        }
        return res;
    }
}
