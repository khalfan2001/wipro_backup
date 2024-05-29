package com.Day13;
//Task-2-page-2
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            currentNode = currentNode.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        currentNode.isEndOfWord = true;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (char ch : prefix.toCharArray()) {
            currentNode = currentNode.children.get(ch);
            if (currentNode == null) {
                return false;
            }
        }
        return true;
    }
}
package com.Day13;
import java.util.HashMap;
import java.util.Map;
//task-2 page-1
public class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

package com.Day13;

public class TrieTest {

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words into the trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");
        trie.insert("band");
        trie.insert("bandana");

        // Check if certain prefixes are present in the trie
        System.out.println("Prefix 'app': " + trie.startsWith("app")); // true
        System.out.println("Prefix 'ban': " + trie.startsWith("ban")); // true
        System.out.println("Prefix 'band': " + trie.startsWith("band")); // true
        System.out.println("Prefix 'bat': " + trie.startsWith("bat")); // false
        System.out.println("Prefix 'cat': " + trie.startsWith("cat")); // false
    }
}
//Task-2-page-3
