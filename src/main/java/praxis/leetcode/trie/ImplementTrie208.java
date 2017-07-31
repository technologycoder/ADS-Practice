package praxis.leetcode.trie;

public class ImplementTrie208 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static class Trie {

        private class TrieNode {
            public char val;
            public boolean isWord;
            public TrieNode[] children;

            public TrieNode(char ch) {
                this.val = ch;
                this.isWord = false;
                this.children = new TrieNode[26];
            }
        }

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new TrieNode(' ');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {

            TrieNode iter = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (iter.children[index] == null) {
                    iter.children[index] = new TrieNode(ch);
                }
                iter = iter.children[index];
            }
            iter.isWord = true;

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {

            TrieNode iter = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (iter.children[index] == null)
                    return false;
                iter = iter.children[index];
            }
            return iter.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {

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

}
