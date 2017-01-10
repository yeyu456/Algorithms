package com.algorithms.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 222. Count Complete Tree Nodes
 *
 *  Given a complete binary tree, count the number of nodes.
 *
 *  Definition of a complete binary tree from Wikipedia:
 *  In a complete binary tree every level, except possibly the last,
 *  is completely filled, and all nodes in the last level are as far left as possible.
 *  It can have between 1 and 2h nodes inclusive at the last level h.
 */

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class CountCompleteTreeNodes {
    
    public static int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            if (root.right != null) {
                TreeNode tmp = root;
                root = root.right;
                tmp.right = null;
                list.add(tmp);
                count++;

            } else if (root.left != null) {
                TreeNode tmp = root;
                root = root.left;
                tmp.left = null;
                list.add(tmp);
                count++;

            } else {
                root = list.remove(list.size() - 1);
            }
        }
        return count;
    }

    public static int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        int h1 = getDepth(root.left);
        while(root != null){
            int h2 = getDepth(root.right);
            if(h1 == h2){
                root = root.right;
            }else{
                root = root.left;
            }
            count += 1 << h2;
            h1--;
        }
        return count;
    }
    
    public static int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            if (countNodes2(getTreeNode(i)) != i) {
                System.out.println("wrong index:" + i);
                break;
            }
        }
    }
    
    public static TreeNode getTreeNode(int size) {
        int rSize = size;
        if (size == 0) {
            return null;
        } else {
            int depth = 0;
            int r = size;
            while (r > 0) {
                r >>= 1;
                depth++;
            }
            if (depth == 1) {
                return new TreeNode(1);
            }
            int lastDepthNodeNum = (1 << (depth - 1));
            int emptyNodeNum = ((1 << depth) - 1  - size);
            int nodeCount = lastDepthNodeNum - emptyNodeNum;
            int curNodeCount = nodeCount;
            List<TreeNode> list = new ArrayList<>();
            do {
                boolean isNode = list.isEmpty();
                int hasChildrenNodeIndex = (nodeCount + 1) / 2; 
                boolean hasSingleLeft = nodeCount % 2 == 1;
                for (int i = curNodeCount;i>0;i--) {
                    if (isNode || i> hasChildrenNodeIndex) {
                        list.add(new TreeNode(size));
                        
                    } else {
                        if (hasSingleLeft) {
                            TreeNode parent = new TreeNode(size);
                            parent.left = list.remove(0);
                            list.add(parent);
                            hasSingleLeft = false;
                            
                        } else {
                            TreeNode parent = new TreeNode(size);
                            parent.right = list.remove(0);
                            parent.left = list.remove(0);
                            list.add(parent);
                        }
                    }
                    size--;
                }
                nodeCount = curNodeCount;
                depth--;
                curNodeCount = 1 << (depth - 1);
            } while (depth > 0);
            if (list.size() == 1) {
                return list.remove(0);
            } else {
                throw new IllegalStateException("Something was wrong with size " + rSize);
            }
        }
    }
}

