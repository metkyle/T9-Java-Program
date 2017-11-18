import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kyle on 10/17/17.
 */
public class Tester {
    public static void main(String[] args) throws Exception {
        List<String> eachWord = new ArrayList<String>();
        Scanner user = new Scanner(System.in);
        DictionaryFile d = new DictionaryFile("dictionary.txt");
        DictPrefixTree prefixTree = new DictPrefixTree();
        DictHashTable hashTable = new DictHashTable();
        List<Integer> keyPresses = new ArrayList<Integer>();
        List<String> keyPermutations = new ArrayList<>();
        long startTime = 0, endTime = 0, timeTaken = 0;
        Pattern p = Pattern.compile("[2-9]+");
        Matcher m;

        //Get all words from the dictionary and put them into a list
        eachWord = d.getWord();

        //Add all the words to the hashtable and prefix tree
        for(int i = 0; i < eachWord.size(); i++){
            //System.out.println(eachWord.get(i));
            prefixTree.insertString(eachWord.get(i));
            hashTable.addWord(i, eachWord.get(i));
        }

        System.out.println("Enter a series of digits in range 2-9:");
        String inputKeys = user.nextLine();
        m = p.matcher(inputKeys);

        if(m.matches() == false){
            throw new Exception("Error in input (digits 2-9 only)");
        }
        for(int i = 0; i < inputKeys.length(); i++){
            keyPresses.add(Integer.parseInt(inputKeys.substring(i, i+1)));
            //System.out.println(keyPresses.get(i));
        }
        SolverTree solverTree = new SolverTree();
        startTime = System.currentTimeMillis();
        keyPermutations = solverTree.makePermutations(keyPresses);
        endTime = System.currentTimeMillis();
        timeTaken = (endTime - startTime);
        System.out.print("Time taken to make Solver Tree(msec): " + timeTaken +"\n\n");
        System.out.println("Words Found from Prefix Tree:");

        startTime = System.currentTimeMillis();
        for(int i = 0; i < keyPermutations.size(); i ++){

            if(prefixTree.findWord(keyPermutations.get(i)) == true){
               System.out.print(keyPermutations.get(i) + ", ");
            }
        }
        System.out.println();
        endTime = System.currentTimeMillis();
        timeTaken = (endTime - startTime);
        System.out.print("Time taken to search Prefix Tree(msec): " + timeTaken + "\n\n");
        System.out.println("Words Found from Hashtable: ");

        startTime = System.currentTimeMillis();
        for(int i = 0; i < keyPermutations.size(); i++){
            if(hashTable.checkForWord(keyPermutations.get(i))){
                System.out.print(keyPermutations.get(i) + ", ");
            }
        }
        System.out.println();
        endTime = System.currentTimeMillis();
        timeTaken = (endTime - startTime);
        System.out.print("Time taken to search Hashtable(msec): " + timeTaken + "\n\n");
        //prefixTree.printSorted();
        //hashTable.printHashTable(eachWord);
        //System.out.println(hashTable.checkForWord("apple"));
    }
}
