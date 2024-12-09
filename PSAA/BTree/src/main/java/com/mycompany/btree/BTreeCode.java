package com.mycompany.btree;

import java.util.Stack;

class BNode<E> {
    public E info;
    public BNode<E> left, right;
    static int LEFT = 1, RIGHT = 2;
    
    public BNode(E info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }
    
    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
}

class BTree<E> {
    public BNode<E> root;
    
    public BTree() {
        root = null;
    }
    
    public BTree(E info) {
        root = new BNode<E>(info);
    }
    
    public BNode<E> addChild(BNode<E> node, int where, E info) {
        BNode<E> tmp = new BNode<E>(info);
        
        if (where == BNode.LEFT) {
            if (node.left != null) {
                return null;
            }
            node.left = tmp;
        } else {
            if (node.right != null) {
                return null;
            }
            node.right = tmp;
        }
        
        return tmp;
    }
    
    public void inorder(BNode<E> r) {
        if (r != null) {
            inorder(r.left);
            System.out.println(r.info);
            inorder(r.right);
        }
    }
    
    public void preorder(BNode<E> r) {
        if (r != null) {
            System.out.println(r.info);
            preorder(r.left);
            preorder(r.right);
        }
    }
    
    public void postorder(BNode<E> r) {
        if (r != null) {
            postorder(r.left);
            postorder(r.right);
            System.out.println(r.info);
        }
    }
    
    public void inorderUsingStack(BNode<E> r) {
        Stack<BNode<E>> s = new Stack();
        
        BNode<E> p = root;
        
        while (true) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            
            if (s.isEmpty()) {
                break;
            }
            
            p = s.pop();
            
            System.out.println(p.info.toString());
            
            p = p.right;
        }
    }
    
    int numLeaves(BNode<E> r) {
        if (r == null) {
            return 0;
        }
        if (r.left == null && r.right == null) {
            return 1;
        } else {
            return numLeaves(r.left) + numLeaves(r.right);
        }
    }
    
    int numInNodes(BNode<E> r) {
        if (r == null) {
            return 0;
        }
        if (r.left == null && r.right == null) {
            return 0;
        } else {
            return 1 + numInNodes(r.left) + numInNodes(r.right);
        }
    }
}

public class BTreeCode {
    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<Integer>(10);
        tree.addChild(tree.root, 1, 5);
        tree.addChild(tree.root.left, 1, 4);
        tree.addChild(tree.root, 0, 7);
        tree.addChild(tree.root.left, 0, 2);
        tree.addChild(tree.root.right, 1, 3);
        tree.addChild(tree.root.right.left, 1, 2);
        
        tree.inorder(tree.root);
        System.out.println("");
        
//        tree.inorderUsingStack(tree.root);
        
        System.out.println(tree.numLeaves(tree.root));
        System.out.println(tree.numInNodes(tree.root));

    }
    
}