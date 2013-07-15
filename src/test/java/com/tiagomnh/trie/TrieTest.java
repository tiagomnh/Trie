package com.tiagomnh.trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrieTest {

    @Test
    public void testEmptyTrie() {
        Trie<Integer> trie = new Trie<Integer>();
        Integer result = trie.find("Value");

        Assert.assertEquals(result, null);
    }

    @Test
    public void testEmptyKey() {
        Trie<Integer> trie = new Trie<Integer>();

        trie.add("", 100);
        Integer result = trie.find("");
        Assert.assertEquals(result, (Integer) 100);

        trie.add("", 200);
        result = trie.find("");
        Assert.assertEquals(result, (Integer) 200);
    }

    @Test
    public void testSingletonTrie() {
        Trie<String> trie = new Trie<String>();
        trie.add("key", "value");
        String result = trie.find("key");

        Assert.assertNotEquals(result, "key");
    }

    @Test
    public void testLargeInsertionAndSearch() {

        Trie<Long> trie = new Trie<Long>();
        List<String> keys = new ArrayList<String>();

        for (int i = 0; i < 10000; i++) {
            Random random = new Random();
            Long value = random.nextLong();
            String key = value.toString();

            trie.add(key, value);
            keys.add(key);
        }

        for (String key : keys) {
            Long value = trie.find(key);
            Assert.assertEquals(key, value.toString());
        }
    }
}
