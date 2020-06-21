class Trie {

    public boolean isEnd;

    public Trie[] tries;

    public int R = 26;

    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        tries = new Trie[R];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || "".equals(word)) return;
        Trie root = this;
        char[] arr = word.toCharArray();
        for (int i = 0;i < arr.length;i++) {
            if (root.tries[arr[i] - 'a'] == null) {
                root.tries[arr[i] - 'a'] = new Trie(); 
            }
            root = root.tries[arr[i] - 'a'];
        }
        root.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = findNode(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = findNode(prefix);
        return node != null;
    }

    public Trie findNode(String word) {
        Trie root = this;
        for (char c : word.toCharArray()) {
            if (root.tries[c - 'a'] == null) {
                return null;
            }
            root = root.tries[c - 'a'];
        }
        return root;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
