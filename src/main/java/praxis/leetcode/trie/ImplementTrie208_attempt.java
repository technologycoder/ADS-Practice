package praxis.leetcode.trie;

public class ImplementTrie208_attempt {

    public static void main(String[] args) {

    }

    public static class Trie {

        private char val;
        private Trie[] children;
        private boolean isWord;

        /** Initialize your data structure here. */
        public Trie() {
            this.children = new Trie[26];

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {

            if (word != null && word.length() > 0) {
                char c = word.charAt(0);

                int index = c - 'a';
                Trie temp = this.children[index];
                if (temp == null) {
                    temp = new Trie();
                    temp.val = c;
                    this.children[index] = temp;

                }
                if (word.length() == 1)
                    temp.isWord = true;
                temp.insert(word.substring(1));
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {

            if (word != null && word.length() > 0) {
                char c = word.charAt(0);

                int index = c - 'a';
                Trie temp = this.children[index];
                if (temp == null) {
                    return false;
                } else {
                    if (word.length() == 1 && temp.isWord)
                        return true;
                    else {
                        return temp.search(word.substring(1));
                    }
                }
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {

            return false;

        }
    }

}
