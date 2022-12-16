package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/index-pairs-of-a-string/
 */
class IndexPairsOfAString {
    @Test
    void indexPairsTest() {
        assertArrayEquals(new int[][]{
                {3,7},{9,13},{10,17}
        }, indexPairs("thestoryofleetcodeandme", new String[]{"story", "fleet", "leetcode"}));

        assertArrayEquals(new int[][]{
                {0,1},{0,2},{2,3},{2,4}
        }, indexPairs("ababa", new String[]{"aba", "ab"}));

        assertArrayEquals(new int[][]{
                {0,0},{0,1},{1,1},{1,2},{2,2},{3,3},{3,4},{4,4},{4,5},{5,5},{5,6},{6,6},{6,7},{7,7},{7,8},{8,8},{8,9},{9,9}
        }, indexPairs("baabaaaaaa", new String[]{"b","a","ba","bb","aa"}));
    }

    public int[][] indexPairs(String text, String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (trie.root.children.containsKey(character)) {
                Trie.TrieNode current = trie.root.children.get(character);
                if (current.isWord) {
                    result.add(Arrays.asList(i, i));
                }
                for (int j = i + 1; j < text.length(); j++) {
                    if (current.children.containsKey(text.charAt(j))) {
                        current = current.children.get(text.charAt(j));
                        if (current.isWord) {
                            result.add(Arrays.asList(i, j));
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        int[][] response = new int[result.size()][2];
        int index = 0;
        for (List<Integer> lists : result) {
            response[index][0] = lists.get(0);
            response[index++][1] = lists.get(1);
        }

        return response;
    }

    class Trie {
        class TrieNode {
            boolean isWord;
            Map<Character, TrieNode> children = new HashMap<>();
        }

        TrieNode root = new TrieNode();

        void addWord(String word) {
            TrieNode current = root;

            for (Character c : word.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);
            }

            current.isWord = true;
        }
    }
}
