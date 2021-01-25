package com.algorithms.tree;

import java.util.*;

/**
 * @author fanbo@imoran.net
 * @date 2020/12/8 18:12
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        inorderTraversalRecursive(root, result);
        return result;
    }

    private void inorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursive(root.left, result);
        result.add(root.val);
        inorderTraversalRecursive(root.right, result);
    }


    public List<Integer> inorderTraversalMorris(TreeNode root) {
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

    /**
     * 迭代中序遍历二叉树
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalIterate(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (stack.size() > 0 || root != null) {
            //不断往左子树方向走，每走一次就将当前节点保存到栈中
            //这是模拟递归的调用
            if (root != null) {
                stack.add(root);
                root = root.left;
                //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
                //然后转向右边节点，继续上面整个过程
            } else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution94 sln = new Solution94();
        // 根据给定的数组创建一棵树ion
        TreeNode root = ConstructTree.constructTree(new Integer[]{1, 2, 3, 4, 5, 6});
        // 将刚刚创建的树打印出来
        TreeOperation.show(root);

        List<Integer> result = sln.inorderTraversal(root);
        System.out.println("########################################################");
        for (Integer integer : result) {
            System.out.print(integer + ",");
        }

        List<Integer> result2 = sln.inorderTraversalIterate(root);
        System.out.println("\n########################################################");
        for (Integer integer : result2) {
            System.out.print(integer + ",");
        }

        List<Integer> result3 = sln.inorderTraversalMorris(root);
        System.out.println("\n########################################################");
        for (Integer integer : result3) {
            System.out.print(integer + ",");
        }
    }

}
