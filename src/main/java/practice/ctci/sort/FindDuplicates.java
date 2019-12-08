package practice.ctci.sort;

import java.util.Arrays;
import java.util.BitSet;

public class FindDuplicates {
    public static void main(String[] args) {

        BitSet b = new BitSet();
        b.set(2);
        b.set(5);

        System.out.println(b);
        System.out.println(Arrays.toString(b.toLongArray()));

        System.out.println(Long.toBinaryString(36));

        // Get values of these bit positions.
        boolean bit1 = b.get(5);
        boolean bit2 = b.get(10);
        boolean bit3 = b.get(100);

        System.out.println(bit1);
        System.out.println(bit2);
        System.out.println(bit3);
    }

    public static void testLocalBitSet() {

        // int size = 33;
        // BitSet bitset = new BitSet(size);

        // System.out.println(size >> 5);

        // System.out.println(32 & 0x1F);

        // System.out.println(0x1F);

        // System.out.println(bitset.arr.length);

    }

    public static class Bitset {
        public int[] arr;

        public Bitset(int size) {

            arr = new int[(size >> 5) + 1];
        }

        public boolean get(int pos) {

            int wordNumber = (pos >> 5);
            int bitNumber = (pos & 0x1F);
            return (arr[wordNumber] & (1 << bitNumber)) != 0;
        }

        public void set(int pos) {

            int wordNumber = (pos >> 5);
            int bitNumber = (pos & 0x1F);
            arr[wordNumber] |= 1 << bitNumber;
        }

    }

}
