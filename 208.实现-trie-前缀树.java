import LRUCache.Node;

/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    class TrieNode{
        private TrieNode[] array ; 
        private boolean end;
        public TrieNode(){
            array = new TrieNode[26];
        }

        public void setNode(char ch, TrieNode node){
             array[ch -'a'] = node;
        }

        public TrieNode getNode(char ch){
             return array[ch-'a'];
        }
        public boolean contain(char ch){
            return array[ch-'a'] != null;
        }


        public boolean isEnd(){
            return this.end;
        }

        public void setEnd(boolean isEnd){
            this.end = isEnd;
        }
    }
   
    /** Initialize your data structure here. */
    private TrieNode root;
    public Trie() {
         root = new TrieNode();
    }

    
    /** Inserts a word into the trie. */
    public void insert(String word) {
         char[] charArr = word.toCharArray();
         char curChar;
         TrieNode node = root;
         for(int i = 0; i < charArr.length; i++){
             curChar = charArr[i];
             if(!node.contain(curChar)){
                 node.setNode(curChar, new TrieNode());
             }
             node = node.getNode(curChar);
         }
         node.setEnd(true);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] charArr = word.toCharArray();
        char curChar;
        TrieNode node = root;
        for(int i = 0; i < charArr.length; i++){
             curChar = charArr[i];
             if(node.contain(curChar)){
                 node = node.getNode(curChar);
             }else{
                 return false;
             }
        }
        return node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] charArr = prefix.toCharArray();
        char curChar;
        TrieNode node = root;
        for(int i = 0; i < charArr.length; i++){
             curChar = charArr[i];
             if(node.contain(curChar)){
                 node = node.getNode(curChar);
             }else{
                 return false;
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
// @lc code=end

