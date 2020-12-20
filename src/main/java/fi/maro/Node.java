/* mbor1 created on 20.12.2020 
inside the package - fi.maro */

package fi.maro;

import protostream.com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void addNode(int i) {
        if (this.value >= i) {
            if (this.left == null) {
                this.left = new Node(i);
            } else {
                this.left.addNode(i);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(i);
            } else {
                this.right.addNode(i);
            }
        }
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public String findMin() {
        if (this.left == null) {
            return sVal();
        } else {
            return sVal() + " > " + this.left.findMin();
        }
    }

    public String findMax() {
        if (this.right == null) {
            return sVal();
        } else {
            return sVal() + " > " + this.right.findMax();
        }
    }

    private String sVal() {
        return String.valueOf(this.value);
    }

    public String inorder() {
        String s = "";
        s += sBranch(this.left);
        s += sVal() + " ";
        s += sBranch(this.right);
        return s;
    }

    public String postorder() {
        String s = "";
        s += sBranch(this.left);
        s += sBranch(this.right);
        s += sVal() + " ";
        return s;
    }

    public String preorder() {
        String s = "";
        s += sVal() + " ";
        s += sBranch(this.left);
        s += sBranch(this.right);
        return s;
    }

    private String sBranch(Node right) {
        if (right != null) {
            return right.inorder();
        }
        return "";
    }

    public String find(int i) {
        if (this.value == i) {
            return " " + sVal();
        }
        if (i > this.value && this.right != null) {
            return " " + sVal() + this.right.find(i);
        }
        if (i < this.value && this.left != null) {
            return " " + sVal() + this.left.find(i);
        }
        return "There is no " + i + " element in the tree.";
    }

    public void remove(int i) {
        if(this.value > i){
            if (this.left.getValue() == i) {
                setLeft(null);
            } else {
                this.left.remove(i);
            }
        }
        if(this.value < i){
            if (this.right.getValue() == i) {
                setLeft(null);
            } else {
                this.right.remove(i);
            }
        }
    }
}
