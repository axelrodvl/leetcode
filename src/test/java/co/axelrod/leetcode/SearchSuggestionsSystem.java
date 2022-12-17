package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * https://leetcode.com/problems/search-suggestions-system/
 */
class SearchSuggestionsSystem {
    @Test
    void suggestedProductsTest() {
        assertIterableEquals(
                Arrays.asList(
                        Arrays.asList("mobile", "moneypot", "monitor"),
                        Arrays.asList("mobile", "moneypot", "monitor"),
                        Arrays.asList("mouse", "mousepad"),
                        Arrays.asList("mouse", "mousepad"),
                        Arrays.asList("mouse", "mousepad")
                ),
                suggestedProducts(
                        new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"},
                        "mouse")
        );

        assertIterableEquals(
                Arrays.asList(
                        Arrays.asList("havana"),
                        Arrays.asList("havana"),
                        Arrays.asList("havana"),
                        Arrays.asList("havana"),
                        Arrays.asList("havana"),
                        Arrays.asList("havana")
                ),
                suggestedProducts(
                        new String[]{"havana"},
                        "havana")
        );

        assertIterableEquals(
                Arrays.asList(
                        Collections.emptyList(),
                        Collections.emptyList(),
                        Collections.emptyList(),
                        Collections.emptyList(),
                        Collections.emptyList(),
                        Collections.emptyList(),
                        Collections.emptyList()
                ),
                suggestedProducts(
                        new String[]{"havana"},
                        "tatiana")
        );

        assertIterableEquals(
                Arrays.asList(
                        Arrays.asList("bee", "beeline", "beer"),
                        Arrays.asList("bee", "beeline", "beer"),
                        Arrays.asList("bee", "beeline", "beer"),
                        Collections.emptyList()
                ),
                suggestedProducts(
                        new String[]{"bee", "beer", "beeline"},
                        "beem")
        );
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.addWord(product);
        }

        List<List<String>> suggestions = new ArrayList<>(searchWord.length());
        for (int i = 1; i <= searchWord.length(); i++) {
            suggestions.add(trie.findWord(searchWord.substring(0, i)));
        }

        return suggestions;
    }

    static class TrieNode {
        boolean isWord;
        TreeMap<Character, TrieNode> children = new TreeMap<>();
    }

    class Trie {
        final int SUGGESTIONS_LIMIT = 3;
        int words = 0;
        int longest = 0;
        char[] foundWord = null;
        TrieNode root = new TrieNode();

        void addWord(String word) {
            TrieNode current = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);
            }
            current.isWord = true;
            words++;
            longest = Math.max(longest, word.length());
        }

        Set<TrieNode> visited = new HashSet<>();
        Set<TrieNode> finished = new HashSet<>();
        Stack<TrieNode> stack = new Stack<>();

        List<String> dfs(TrieNode trieNode, char[] word, int wordLength) {
            visited.clear();
            finished.clear();
            stack.clear();

            List<String> result = new ArrayList<>();

            stack.push(trieNode);

            if (trieNode.isWord) {
                result.add(new String(word, 0, wordLength));
            }

            while (!stack.isEmpty()) {
                TrieNode current = stack.peek();
                if (!finished.contains(current)) {
                    visited.add(current);
                    TrieNode next = null;
                    for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
                        if (!visited.contains(entry.getValue())) {
                            next = entry.getValue();
                            word[wordLength++] = entry.getKey();
                            if (entry.getValue().isWord) {
                                result.add(new String(word, 0, wordLength));
                                if (result.size() == SUGGESTIONS_LIMIT) {
                                    return result;
                                }
                            }
                            break;
                        }
                    }
                    if (next == null) {
                        finished.add(current);
                    } else {
                        stack.push(next);
                    }
                } else {
                    stack.pop();
                    wordLength--;
                }
            }

            return result;
        }

        List<String> findWord(String word) {
            if (foundWord == null) {
                foundWord = new char[longest];
            }

            if (word.length() > longest) {
                return Collections.emptyList();
            }

            int foundWordLength = 0;
            TrieNode current = root;

            // Find prefix for word
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.children.containsKey(c)) {
                    current = current.children.get(c);
                    foundWord[foundWordLength++] = c;
                } else {
                    return Collections.emptyList();
                }
            }

            if (foundWordLength == 0) {
                return Collections.emptyList();
            }

            return dfs(current, foundWord, foundWordLength);
        }
    }
}
