class PrefixTree {

    class TrieNode {
        HashMap<Character, TrieNode> childNodes;
        boolean isEndOfWord;

        TrieNode() {
        }

        TrieNode(HashMap<Character, TrieNode> childNodes, boolean isEndOfWord) {
            this.childNodes = childNodes;
            this.isEndOfWord = isEndOfWord;
        }
    }

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();

        TrieNode curr = this.root;

        int ind = 0;
        while (ind < chars.length) {
            if (curr.childNodes != null && curr.childNodes.containsKey(chars[ind])) {
                curr = curr.childNodes.get(chars[ind]);
                ind++;
            } else {
                break;
            }
        }

        for (int i = ind; i < chars.length; i++) {
            char c = chars[i];
            if (curr.childNodes == null) {
                curr.childNodes = new HashMap<Character, TrieNode>();
            }
            curr.childNodes.put(c, new TrieNode());
            curr = curr.childNodes.get(c);
        }

        curr.isEndOfWord = true;
        // System.out.println("word " + word);
        // dfsTrie(this.root);
    }

    public void dfsTrie(TrieNode node) {
        if (node.childNodes == null)
            return;

        for (Character key : node.childNodes.keySet()) {
            System.out.println("key " + key);
            System.out.println("isEndOfWord " + node.isEndOfWord);
            dfsTrie(node.childNodes.get(key));
        }
    }

    public boolean search(String word) {
        if (this.root.childNodes == null)
            return false;

        char[] chars = word.toCharArray();

        TrieNode curr = this.root;

        for (int i = 0; i < chars.length; i++) {
            if (curr.childNodes == null || !curr.childNodes.containsKey(chars[i])) {
                return false;
            } else {
                curr = curr.childNodes.get(chars[i]);
            }
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        if (this.root.childNodes == null)
            return false;

        char[] chars = prefix.toCharArray();

        TrieNode curr = this.root;

        for (int i = 0; i < chars.length; i++) {
            if (curr.childNodes == null || !curr.childNodes.containsKey(chars[i])) {
                return false;
            } else {
                curr = curr.childNodes.get(chars[i]);
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */