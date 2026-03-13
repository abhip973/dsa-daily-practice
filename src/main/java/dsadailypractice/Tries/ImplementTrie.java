package dsadailypractice.Tries;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
}

public class ImplementTrie {
    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = this.root;
            for (char ch : word.toCharArray()) {
                if (!curr.children.containsKey(ch)) {
                    curr.children.put(ch, new TrieNode());
                }
                curr = curr.children.get(ch);
            }
            curr.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode curr = this.root;
            for (char ch : word.toCharArray()) {
                if (!curr.children.containsKey(ch)) {
                    return false;
                }
                curr = curr.children.get(ch);
            }
            return curr.isEndOfWord;
        }

        public boolean prefix(String word) {
            TrieNode curr = this.root;
            for (char ch : word.toCharArray()) {
                if (!curr.children.containsKey(ch)) return false;
                curr = curr.children.get(ch);
            }
            return true;
        }
    }
}
