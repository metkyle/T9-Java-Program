import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.*;
/**
 * Created by kyle on 10/20/17.
 */
//Represents the keypad, which maps digits to their respective list of characters
public class Keypad {

    private HashMap<Integer, List<Character>> keypad;

    //Represents the keys a user can enter, and their respective characters
    public Keypad(){
        this.keypad = new HashMap<Integer, List<Character>>();
        keypad.put(2, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')));
        keypad.put(3, new ArrayList<Character>(Arrays.asList('d', 'e', 'f')));
        keypad.put(4, new ArrayList<Character>(Arrays.asList('g', 'h', 'i')));
        keypad.put(5, new ArrayList<Character>(Arrays.asList('j', 'k', 'l')));
        keypad.put(6, new ArrayList<Character>(Arrays.asList('m', 'n', 'o')));
        keypad.put(7, new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's')));
        keypad.put(8, new ArrayList<Character>(Arrays.asList('t', 'u', 'v')));
        keypad.put(9, new ArrayList<Character>(Arrays.asList('w', 'x', 'y','z')));
    }

    public HashMap<Integer,List<Character>> getKeypad(){
        return this.keypad;
    }
}
