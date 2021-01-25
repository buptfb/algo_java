package com.algorithms.tree.codinginterview;

import com.algorithms.tree.ConstructTree;
import com.algorithms.tree.TreeNode;
import com.algorithms.tree.TreeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fanbo@imoran.net
 * @date 2021/1/24 4:48
 */
public class Codec37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        StringBuilder res = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode != null) {
                res.append(curNode.val+",");
                queue.offer(curNode.left);
                queue.offer(curNode.right);
            } else {
                res.append("null,");
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data=="") {
            return null;
        }
        String[] val = data.substring(0, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        int cur = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (!"null".equals(val[cur])){
                curNode.left = new TreeNode(Integer.valueOf(val[cur]));
                queue.offer(curNode.left);
            }
            cur++;
            if (!"null".equals(val[cur])) {
                curNode.right = new TreeNode(Integer.valueOf(val[cur]));
                queue.offer(curNode.right);
            }
            cur++;
        }
        return root;
    }


    public static TreeNode generateNodeByString(String val) {
        if (val.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }

    public static void main(String[] args) {
        Codec37 sln = new Codec37();
        // 根据给定的数组创建一棵树ion
        TreeNode root = ConstructTree.constructTree(new Integer[]{1, 2, 3, null, null, 4, 5});
        // 将刚刚创建的树打印出来
        TreeOperation.show(root);

        String res = sln.serialize(root);
        System.out.println(res);
        System.out.println("#######################3");

        TreeNode treeNode = sln.deserialize(res);
        TreeOperation.show(treeNode);
    }

}
