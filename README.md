## Trie

Trie implementation in Java.

### Build

`mvn install`

### API

```java
Trie<Integer> trie = new Trie<Integer>(); // stuff
trie.add("uno", 1); // uno = 1
trie.add("dos", 2); // dos = 2

trie.find("dos") // returns 2
trie.find("catorze") // returns null
```

### License

[MIT License](http://opensource.org/licenses/MIT) (c) [Tiago Henriques](mailto:tiagomnh@gmail.com)
