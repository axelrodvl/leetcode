package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
class ImplementTriePrefixTree {
    @Test
    void trieTest() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
    }

    class Trie {
        class TrieNode {
            boolean isWord = false;
            Map<Character, TrieNode> children = new HashMap<>();
        }

        TrieNode root = new TrieNode();

        public Trie() {

        }

        public void insert(String word) {
            TrieNode current = root;

            for (Character character : word.toCharArray()) {
                if (!current.children.containsKey(character)) {
                    current.children.put(character, new TrieNode());
                }
                current = current.children.get(character);
            }

            current.isWord = true;
        }

        public boolean search(String word) {
            TrieNode current = root;

            for (Character character : word.toCharArray()) {
                if (current.children.containsKey(character)) {
                    current = current.children.get(character);
                } else {
                    return false;
                }
            }

            return current.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;

            for (Character character : prefix.toCharArray()) {
                if (current.children.containsKey(character)) {
                    current = current.children.get(character);
                } else {
                    return false;
                }
            }

            return true;
        }
    }
}
