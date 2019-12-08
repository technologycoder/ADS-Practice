package praxis.leetcode.trie;

import java.util.LinkedList;
import java.util.List;

public class ConcatenatedWords472_1 {
    public static void main(String[] args) {

        String[] words = {"cat", "cats", "catsxyzdogxyzcats", "dog", "dogxzcatsxzdog", "hippopotamuses", "rat", "ratxzcatxzdogxzcat"};
        // String[] words = { "cat", "cats", "catszdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
        System.out.println(findAllConcatenatedWordsInADict(words));

    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> res = new LinkedList<>();
        Trie root = new Trie();
        for (String s : words) {// build tree
            if (s.length() == 0)
                continue; // skip "" !
            Trie p = root;
            for (char c : s.toCharArray()) {
                if (p.next[c - 'a'] == null)
                    p.next[c - 'a'] = new Trie();
                p = p.next[c - 'a'];
            }
            p.word = s;
        }
        for (String s : words)
            if (dfs(s, root, 0, root))
                res.add(s); // check each word using the tree
        return res;
    }

    private static boolean dfs(String s, Trie t, int p, Trie root) {
        // return true, if we reach a word at the end & the original word s is a concatenated word
        if (p == s.length())
            return t.word != null && !t.word.equals(s);
        if (t.next[s.charAt(p) - 'a'] == null)
            return false;
        // reached a word, try to start from root again
        if (t.next[s.charAt(p) - 'a'].word != null && dfs(s, root, p + 1, root))
            return true;
        // keep going
        return dfs(s, t.next[s.charAt(p) - 'a'], p + 1, root);
    }

    public static class Trie {
        Trie[] next = new Trie[26];

        String word = null;
    }

}
