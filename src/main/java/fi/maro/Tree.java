/* mbor1 created on 20.12.2020 
inside the package - fi.maro */

package fi.maro;

import protostream.com.google.gson.Gson;

public class Tree {
    private Node root;

    public Tree(int[] tab) {
        this.root = new Node(tab[0]);

        for (int i=1; i<tab.length; i++) {
            this.root.addNode(tab[i]);
        }
    }

    public String findMin() {
        return root.findMin();
    }

    public String findMax() {
        return root.findMax();
    }

    public String inorder() {
        return root.inorder();
    }

    public String postorder() {
        return root.postorder();
    }

    public String preorder() {
        return root.preorder();
    }

    public String find(int i) {
        return root.find(i);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public void remove(int i) {
        if (root.getValue() == i){

        }
        root.remove(i);
    }

//    public void remove(int i) {
//        return root.remove(i);
//    }
}
