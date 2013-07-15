package com.tiagomnh.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie<A> {

    private A value;
    private Map<Character, Trie> children;

    public Trie() {

        value = null;
        children = new HashMap<Character, Trie>();
    }

    public void add(String word, A value) {
        if (word == null) {
            return;
        }

        if (word.isEmpty()) {
            this.value = value;
            return;
        }

        char c = word.charAt(0);
        Trie childTrie = children.get(c);
        if (childTrie == null) {
            childTrie = new Trie();
            children.put(c, childTrie);
        }

        childTrie.add(word.substring(1), value);
    }

    public A find(String key) {

        Trie<A> node = this;
        char[] keyCharacters = key.toCharArray();

        for (Character c : keyCharacters) {
            if (!node.getChildren().containsKey(c)) {
                return null;
            }

            node = node.getChildren().get(c);
        }

        return node.value;
    }

    private Map<Character, Trie> getChildren() {
        return children;
    }

    private A getValue() {
        return value;
    }

    private void setValue(A value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Trie{" +
                "value=" + value +
                ", children=" + children +
                '}';
    }
}
