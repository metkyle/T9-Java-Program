import java.util.Map;
import java.util.TreeMap;

/**
 * Created by kyle on 10/19/17.
 */
//A prefix tree representing words in a dictionary
public class DictPrefixTree {

    public class TrieNode{
        Map<Character, TrieNode> children = new TreeMap<>();
        boolean aWord = false;

        public TrieNode(){
            aWord = false;
        }

        public boolean isAWord(){
            return this.aWord;
        }
    }

    private TrieNode root;

    public DictPrefixTree(){
        this.root = new TrieNode();

    }

    public void insertString(String s){
        insertString(this.root, s);
    }

    private void insertString(TrieNode root, String s){
        TrieNode cur = root;
        for(char ch : s.toCharArray()){
            TrieNode next = cur.children.get(ch);
            if(next == null){
                next = new TrieNode();
                cur.children.put(ch, next);

            }
            cur = next;
        }
        cur.aWord = true;
    }

    //Print method for debug purposes
    /*public void printSorted(){
        printSorted(root, "");
    }

    private void printSorted(TrieNode node, String s){
        if(node.aWord){
            System.out.println(s);
        }
        for(Character ch : node.children.keySet()){
            printSorted(node.children.get(ch), s + ch);
        }
    }*/


    public boolean findWord(String s){
        return findWord(root, s);
    }

    private boolean findWord(TrieNode node, String s){

        if(s != null){
            String rest = s.substring(1);
            char ch = s.charAt(0);

            TrieNode child = node.children.get(ch);
            if(s.length() == 1 && child != null){

                if(child.aWord == true)
                    return true;
                else
                    return false;
            }

            if(child == null)
                return false;
            else
                return findWord(child, rest);
        }
        return false;
    }

}
