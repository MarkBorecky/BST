/* mbor1 created on 20.12.2020 
inside the package - fi.maro */

package fi.maro;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static Random r = new Random();
    public static void main(String[] args) {
        int[] ints = generateTab(10, 10);
        Tree t = new Tree(ints);
        System.out.println("t = " + t);
        System.out.println("t.findMax() = " + t.findMax());
        System.out.println("t.findMin() = " + t.findMin());
        System.out.println("t.inorder()   = " + t.inorder());
        System.out.println("t.postorder() = " + t.postorder());
        System.out.println("t.preorder()  = " + t.preorder());
        System.out.println("t.find(5) = " + t.find(5));
        t.remove(5);
        System.out.println("t.inorder()   = " + t.inorder());
        System.out.println("t = " + t);
    }

    public static int[] generateTab(int amount, int range) {
        if (range > amount) {
            throw new IllegalArgumentException("range should be lager or equal amount!");
        }
        int[] numbers = new int[range];
        int[] tab = new int[amount];
        for (int i=0; i<numbers.length; i++) {
            numbers[i] = i;
        }
        for (int i=0; i<tab.length; i++) {
            int j = r.nextInt(numbers.length);
            tab[i] = numbers[j];
            System.out.print(tab[i]+" ");
            numbers[j] = numbers[numbers.length-1];
            numbers = Arrays.copyOf(numbers, numbers.length-1);
        }
        System.out.println();
        return tab;
    }
}
