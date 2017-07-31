package praxis.leetcode.trie;

public class TrieUtil {

    public static class TrieNode {

        char val;
        TrieNode[] children = new TrieNode[26];
        boolean isWord;

        public TrieNode(char val) {
            this.val = val;
        }

    }

    public static TrieNode insert(TrieNode root, String word) {

        if (root == null) {
            root = new TrieNode(' ');
        }

        TrieNode iter = root;
        for (char ch : word.toCharArray()) {

            int index = ch - 'a';
            if (iter.children[index] != null) {
                iter = iter.children[index];
            } else {
                iter.children[index] = new TrieNode(ch);
                iter = iter.children[index];
            }
        }
        iter.isWord = true;

        return root;

    }

    public static boolean search(TrieNode root, String word) {

        if (root == null || word == null || word.length() == 0) {
            return false;
        }

        TrieNode iter = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (iter.children[index] == null) {
                return false;
            } else {
                iter = iter.children[index];
            }

        }

        return iter.isWord;

    }

    public static boolean startsWith(TrieNode root, String prefix) {

        if (root == null || prefix == null || prefix.length() == 0) {
            return false;
        }

        TrieNode iter = root;

        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';

            if (iter.children[index] == null)
                return false;
            iter = iter.children[index];
        }
        return true;

    }

}
