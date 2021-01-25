package com.algorithms.tree;

import com.algorithms.tree.codinginterview.Codec37;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fanbo@imoran.net
 * @date 2021/1/24 5:37
 */
public class Solution297 {
    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }


    public static class Codec {

        String nullNode = "#";
        String seperator = ",";

        // 后根遍历方式序列化二叉树
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return null;
            }

            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(nullNode).append(seperator);
                return;
            }

            serialize(root.left, sb);
            serialize(root.right, sb);
            sb.append(root.val).append(seperator);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) {
                return null;
            }
            LinkedList<String> values = new LinkedList<String>();
            for (String s : data.split(seperator)) {
                if ("".equals(s)) {
                    continue;
                }
                values.addLast(s);
            }

            return deserialize(values);
        }

        TreeNode deserialize(LinkedList<String> values) {
            if (values.size() == 0) {
                return null;
            }

            String rootValue = values.removeLast();
            if (nullNode.equals(rootValue)) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.valueOf(rootValue));

            root.right = deserialize(values);
            root.left = deserialize(values);

            return root;
        }

    }


    public static void main(String[] args) {
        Solution297 sln = new Solution297();
        // 根据给定的数组创建一棵树ion
        TreeNode root = ConstructTree.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        // 将刚刚创建的树打印出来
        TreeOperation.show(root);

        String res = sln.serialize(root);
        System.out.println(res);

        System.out.println("??????????????????????????????????????????");

        Solution297.Codec sln2 = new Codec();
        // 根据给定的数组创建一棵树ion
        TreeNode root2 = ConstructTree.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        // 将刚刚创建的树打印出来
        TreeOperation.show(root2);

        String res2 = sln2.serialize(root2);
        System.out.println(res2);

        TreeOperation.show(sln2.deserialize(res2));
    }

}
