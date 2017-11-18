import java.util.Hashtable;
import java.util.List;

/**
 * Created by kyle on 10/19/17.
 */
//A Hashtable which will hold words from a dictionary file
public class DictHashTable {

    Hashtable<Integer, String> theWords;

    public DictHashTable(){
        theWords = new Hashtable<>();
    }

    public void addWord(Integer i, String s2){
        theWords.put(i, s2);
    }

    public boolean checkForWord(String s){
        if(theWords.contains(s))
            return true;
        else
            return false;

    }

    /*public void printHashTable(List<String> eachWord){
        for(int i = 0; i < theWords.size(); i++){
            System.out.println(theWords.get(eachWord.get(i)));
        }
    }*/
}
