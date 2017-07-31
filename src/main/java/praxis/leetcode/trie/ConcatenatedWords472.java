package praxis.leetcode.trie;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords472 {

    public static void main(String[] args) {
        // String[] words = { "cat", "cats", "catsxyzdogxyzcats", "dog", "dogxzcatsxzdog", "hippopotamuses", "rat", "ratxzcatxzdogxzcat" };

        String[] words = { "cat", "cats", "catszdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
        System.out.println(findAllConcatenatedWordsInADict(words));

    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Trie tree = new Trie();
        for (String s : words) {
            tree.insert(s);
        }
        for (String s : words) {
            System.out.println(s);
            if (helper(s, tree))
                res.add(s);

            System.out.println(res);
            System.out.println("-----------------");
        }
        return res;
    }

    public static boolean helper(String s, Trie tree) {

        // System.out.println(s);
        TrieNode cur = tree.root;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            cur = cur.children[index];
            if (cur == null)
                return false;
            String suffix = s.substring(i + 1);
            // tree.search(suffix) means the combination for this s consists of two words: cur + suffix
            // helper(suffix, tree) means there will be further level searching, the combination consists of more than two words
            if (cur.isWord && (tree.search(suffix) || helper(suffix, tree)))
                return true;
        }
        return false;
    }

    public static class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children;

        public TrieNode(char val) {
            this.val = val;
            this.isWord = false;
            children = new TrieNode[26];
        }
    }

    public static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode(' ');
        }

        public void insert(String s) {
            TrieNode cur = root;
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i] - 'a';
                if (cur.children[index] == null)
                    cur.children[index] = new TrieNode(arr[i]);
                cur = cur.children[index];
            }
            cur.isWord = true;
        }

        public boolean search(String s) {
            TrieNode cur = root;
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i] - 'a';
                if (cur.children[index] == null)
                    return false;
                cur = cur.children[index];
            }
            return cur.isWord;
        }
    }

}
