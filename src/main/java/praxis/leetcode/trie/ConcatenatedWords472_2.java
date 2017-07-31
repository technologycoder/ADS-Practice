package praxis.leetcode.trie;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords472_2 {

    public static void main(String[] args) {
        String[] words = { "cat", "cats", "catsxyzdogxyzcats", "dog", "dogxzcatsxzdog", "hippopotamuses", "rat", "ratxzcatxzdogxzcat" };
        // String[] words = { "cat", "cats", "catszdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
        System.out.println(findAllConcatenatedWordsInADict(words));

    }

    public static class TrieNode {
        TrieNode[] children;
        String word;
        boolean isEnd;
        boolean combo; // if this word is a combination of simple words
        boolean added; // if this word is already added in result

        public TrieNode() {
            this.children = new TrieNode[26];
            this.word = new String();
            this.isEnd = false;
            this.combo = false;
            this.added = false;
        }
    }

    private static void addWord(String str) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
        node.word = str;
    }

    private static TrieNode root;
    private static List<String> result;

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new TrieNode();
        for (String str : words) {
            if (str.length() == 0) {
                continue;
            }
            addWord(str);
        }
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private static void dfs(TrieNode node, int multi) {
        // multi counts how many single words combined in this word
        if (node.isEnd && !node.added && multi > 1) {
            node.combo = true;
            node.added = true;
            result.add(node.word);
        }
        searchWord(node, root, multi);
    }

    private static void searchWord(TrieNode node1, TrieNode node2, int multi) {
        if (node2.combo) {
            return;
        }
        if (node2.isEnd) {
            // take the pointer of node2 back to root
            dfs(node1, multi + 1);
        }
        for (int i = 0; i < 26; i++) {
            if (node1.children[i] != null && node2.children[i] != null) {
                searchWord(node1.children[i], node2.children[i], multi);
            }
        }
    }

}
