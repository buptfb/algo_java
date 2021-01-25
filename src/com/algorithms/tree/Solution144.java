package com.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author fanbo@imoran.net
 * @date 2021/1/9 11:29
 */
public class Solution144 {
    public List<Integer> preOrderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null){
            return null;
        }
        res.add(root.val);
        preOrderTraversal(root, res);
        return res;

    }

    private void preOrderTraversal(TreeNode root, List<Integer> res) {
        if(root == null){
            return;
        }
        res.add(root.val);
        preOrderTraversal(root.left, res);
        preOrderTraversal(root.right, res);
    }



        public List<Integer> preOrderTraversalIterate(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);
        while(!treeNodeStack.isEmpty()){
            TreeNode tmp = treeNodeStack.peek();
            treeNodeStack.pop();
            res.add(tmp.val);

            if(tmp.right != null) {
                treeNodeStack.push(tmp.right);
            }

            if(tmp.left != null){
                treeNodeStack.push(tmp.left);
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode pre = null;
        while(root!=null) {
            //如果左节点不为空，就将当前节点连带右子树全部挂到
            //左节点的最右子树下面
            if(root.left!=null) {
                pre = root.left;
                while(pre.right!=null) {
                    pre = pre.right;
                }
                pre.right = root;
                //将root指向root的left
                TreeNode tmp = root;
                root = root.left;
                tmp.left = null;
                //左子树为空，则打印这个节点，并向右边遍历
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution144 sln = new Solution144();
        // 根据给定的数组创建一棵树ion
        TreeNode root = ConstructTree.constructTree(new Integer[]{1, 2, 3, 4, 5, 6});
        // 将刚刚创建的树打印出来
        TreeOperation.show(root);

        List<Integer> result = sln.preOrderTraversalIterate(root);
        System.out.println("########################################################");
        for (Integer integer : result) {
            System.out.print(integer + ",");
        }

        List<Integer> result2 = sln.preOrderTraversalIterate(root);
        System.out.println("\n########################################################");
        for (Integer integer : result2) {
            System.out.print(integer + ",");
        }
    }
}
