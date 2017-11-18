import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kyle on 10/17/17.
 */
//Reads and parses words from a dictionary file
public class DictionaryFile {
    List<String> eachLine;

    public DictionaryFile(String fileName){
        int i = 0;
        String wordToAdd = "";
        File file = new File(fileName);
        eachLine = new ArrayList<>();
        //Make a new bufferedReader using the file
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            //Read in the file, line by line
            while((wordToAdd = br.readLine()) != null){
                //Remove numbers and commas from each line
                wordToAdd = wordToAdd.replaceAll("\\d","");
                wordToAdd = wordToAdd.replaceAll(",", "");
                //Add the word to our list of words
                eachLine.add(wordToAdd);
                //Print them out, debug purposes only
               // System.out.println(wordToAdd);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getWord(){
        return this.eachLine;
    }
}
