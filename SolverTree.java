import java.util.Map;
import java.util.TreeMap;
import java.util.*;
/**
 * Created by kyle on 10/20/17.
 */
//A tree which holds all permutations made from digits the user enters
public class SolverTree {

    DictPrefixTree.TrieNode root;
    Map<Character, DictPrefixTree.TrieNode> children = new TreeMap<>();
    List<String> foundWords;
    HashMap<Integer, List<Character>> keyMap = new Keypad().getKeypad();

    public SolverTree(){
        this.root = null;
        foundWords = new ArrayList<>();
        //this.keyMap = keyMap;
    }

    public List<String> makePermutations(List<Integer> keyPresses){
        return makePermutations( keyPresses, 0);
    }

    private List<String> makePermutations(List<Integer> keys, int index){
        List<String> permutations = new ArrayList<String>();

        //base case, if index is at the last key,
        if(index >= keys.size()){
                permutations.add("");
            return permutations;
        }
        //The current key is grabbed from the list of digits the user entered
        int currentKey = keys.get(index);

        //Traverse the character array from the keyMap
        for(char firstChar : keyMap.get(currentKey)){

                List<String> suffix = makePermutations(keys, index + 1);

                for(String s : suffix) {
                    permutations.add("" + firstChar + s);

                }
            }

        return permutations;
    }
}
