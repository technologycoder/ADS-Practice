package praxis.array;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.BitSet;

/*
 * Implement an algorithm to determine if a string has all unqiue characters
 */
public class UniqueCharacters {

    public static void main(final String[] args) {

        assertFalse(UniqueCharacters.hasUniqueChars("dogatedogDOGATEDOG"));
        assertTrue("Should be unique", UniqueCharacters.hasUniqueChars("dogateDOG"));

        assertFalse(UniqueCharacters.hasUniqueCharsUsingIntegerBitVector("dogatedogDOGATEDOG"));
        assertTrue(UniqueCharacters.hasUniqueCharsUsingIntegerBitVector("dogate"));

        assertFalse(UniqueCharacters.hasUniqueCharsUsingJavaBitSet("dogatedogDOGATEDOG"));
        assertTrue("Should be unique", UniqueCharacters.hasUniqueCharsUsingJavaBitSet("dogateDOG"));

        assertFalse(UniqueCharacters.hasUniqueCharsUsingBitVector("dogatedogDOGATEDOG"));
        assertTrue("Should be unique", UniqueCharacters.hasUniqueCharsUsingBitVector("dogateDOG"));
    }

    public static boolean hasUniqueChars(final String str) {

        char[] arr = str.toCharArray();

        // both lower and upper case alphabets are handled because we have 128
        // indices
        boolean[] map = new boolean[128];

        for (char c : arr) {

            int index = c;

            if (map[index]) {
                return false;
            } else {
                map[index] = true;
            }
        }
        return true;
    }

    public static boolean hasUniqueCharsUsingIntegerBitVector(final String str) {

        // assuming only lowercase alphabets
        char[] arr = str.toLowerCase()
                        .toCharArray();

        // using 0 - 25 to flip bit for 26 lowercase characters
        int bitVector = 0;

        for (char c : arr) {

            int index = c - 'a';
            int mask = (1 << index);

            if ((bitVector & mask) == mask) {
                // System.out.println(Integer.toBinaryString(bitVector));
                return false;
            } else {
                // System.out.println(Integer.toBinaryString(bitVector));
                bitVector |= mask;
            }
        }
        return true;
    }

    public static boolean hasUniqueCharsUsingJavaBitSet(final String str) {

        BitSet bitSet = new BitSet(128);

        char[] arr = str.toCharArray();

        for (char c : arr) {

            int bitIndex = c;

            if (bitSet.get(bitIndex)) {
                return false;
            } else {
                bitSet.set(bitIndex);
            }
        }

        return true;

    }

    public static boolean hasUniqueCharsUsingBitVector(final String str) {

        BitVector bitVector = new BitVector(128);

        char[] arr = str.toCharArray();

        for (char c : arr) {

            int bitIndex = c;

            if (bitVector.getBit(bitIndex)) {
                return false;
            } else {
                bitVector.setBit(bitIndex);
            }
        }

        return true;

    }

    public static class BitVector {
        private int[] map;

        public BitVector(final int size) {
            map = new int[size / 32 + 1];
        }

        public void setBit(final int index) {

            int element = index / 32;
            int bit = index % 32;

            map[element] |= (1 << bit);

        }

        public boolean getBit(final int index) {

            int element = index / 32;
            int bit = index % 32;

            int mask = (1 << bit);
            return (map[element] & mask) == mask;

        }

    }

}
