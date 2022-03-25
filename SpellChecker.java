import java.util.*;
import java.io.*;

/**
 * Class to check spelling when called from console
 * 
 * @author Anh Nguyen & Sabrina Hatch
 * @version Spring 2022
 **/

public class SpellChecker {
  /**
   * determines the type of operation for spell checking (command line or * file
   * scanning) and checks for misspelt words, then either sub method * returns
   * suggestion for correct words
   * 
   * @param args
   * @return void
   */
  public static void main(String[] args) {
    System.out.println("Initializing dictionary...");
    SpellDictionary dict = new SpellDictionary("words.txt");
    System.out.println("Finish initialisation.");
    if (args.length > 0) {
      commandLine(args, dict);
    } else {
      fileScanning(dict);
    }
  }

  /**
   * reads the command line input and return lists of misspelt words and * their
   * corr. suggestions for correction
   * 
   * @param dict (required) is the dictionary of correct words
   * @param args (required) this is a string array input from the console
   * @return void
   */
  public static void commandLine(String[] args, SpellDictionary dict) {
    for (String word : args) {
      word = word.replaceAll("[ .,?!:;]+", "");
      if (dict.containsWord(word)) {
        System.out.println(word + " is spelled correctly!");
      } else {
        System.out.println("Not found: " + word);
        System.out.print("Suggestions: ");
        System.out.println(" " + dict.nearMisses(word).toString());
      }
    }
  }

  /**
   * reads the txt file and prints out the list of misspelt words and their corr.
   * suggestions for correction
   * 
   * @param dict (required) the dictionary of correctly spelled words
   * @return void
   */
  public static void fileScanning(SpellDictionary dict) {
    Scanner sc = new Scanner(System.in);
    HashSet<String> alrChecked = new HashSet<String>();
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      String split[] = line.split("[ .,?!:;]+");
      for (String word : split) {
        if (!dict.containsWord(word) && alrChecked.contains(word) == false) {
          alrChecked.add(word);
          System.out.println("Misspelt: " + word);
          System.out.print("Suggestions: ");
          System.out.println(" " + dict.nearMisses(word).toString());
        }
      }
    }

    sc.close();
    System.out.println("Done!");
  }
}