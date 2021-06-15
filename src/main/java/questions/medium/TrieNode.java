package questions.medium;

public class TrieNode {

    TrieNode[] links;
    boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    final int R = 26;

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
