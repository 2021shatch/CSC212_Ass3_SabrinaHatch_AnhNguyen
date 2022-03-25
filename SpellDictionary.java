import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class to store a spelling dictionary AKA - logic to help fix typos of
 * misspelled words.
 * 
 * @author Anh Nyguen & Sabrina Hatch
 * @version Spring 2022
 */

public class SpellDictionary {
  /** Stores the dictionary words **/
  private HashSet<String> words = new HashSet<String>();

  // creates a private character array containing each letter in the alphabet
  private static char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

  /**
   * Constructor that takes in all the words from the dictionary and stores each
   * word into the previously declared hashset "words"
   * 
   * @param "filename" which is the word list file
   */
  public SpellDictionary(String filename) {
    Scanner file = null;
    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);
    }
    while (file.hasNextLine()) {
      words.add(file.nextLine());
    }
    file.close();
  }

  /**
   * checks if the dictionary contains a particular spelling (checks to * see if
   * the word entered is correct)
   * 
   * @param spelling (required) - word that needs to be checked against the
   *                 dictionary
   * @return returns a boolean
   **/
  public boolean containsWord(String spelling) {
    return words.contains(spelling);
  }

  /**
   * returns correctly spelled words that are exactly one edit away from * a given
   * incorrect word spelling
   * 
   * @param spelling (required) word to check for spelling
   * @return returns a hashset of correctly spelled words
   */
  public HashSet<String> nearMisses(String spelling) {
    HashSet<String> wordsSuggestion = new HashSet<String>();
    spelling = spelling.replaceAll("[.,;:!?]", "");

    // runs the word through all the sub methods and then adds the corrections to a
    // hashset called wordsSuggestion
    wordsSuggestion.addAll(deletion(spelling));
    wordsSuggestion.addAll(insertion(spelling));
    wordsSuggestion.addAll(substitution(spelling));
    wordsSuggestion.addAll(transposition(spelling));
    wordsSuggestion.addAll(split(spelling));

    return wordsSuggestion;
  }

  /**
   * returns correctly spelled words by deleting one letter from the mispelled
   * word
   * 
   * @param userInput (required) a string to check for spelling
   * @return returns an ArrayList of correctly spelled words
   **/
  public ArrayList<String> deletion(String userInput) {
    ArrayList<String> deletionWords = new ArrayList<String>();

    for (int i = 0; i < userInput.length(); i++) {
      String t = userInput.substring(0, i) + userInput.substring(i + 1);
      if (words.contains(t) && !deletionWords.contains(t)) {
        deletionWords.add(t);
      }
    }
    return deletionWords;
  }

  /**
   * returns correctly spelled words by inserting one letter into the
   * mispelledword
   * 
   * @param userInput (required) a string to be checked for spelling
   * @return returns an ArrayList of correctly spelled words
   **/
  public ArrayList<String> insertion(String userInput) {
    ArrayList<String> insertionWords = new ArrayList<String>();

    for (int i = 0; i <= userInput.length(); i++) {
      for (int n = 0; n < 26; n++) {
        String t = userInput.substring(0, i) + alphabet[n] + userInput.substring(i);
        if (words.contains(t) && !insertionWords.contains(t)) {
          insertionWords.add(t);
        }
      }
    }
    return insertionWords;
  }

  /**
   * returns correctly spelled words by replacing one letter of the mispelled word
   * 
   * @param userInput (required) a string to be checked for spelling
   * @return returns an ArrayList of correctly spelled words
   **/
  public ArrayList<String> substitution(String userInput) {
    ArrayList<String> substitutionWords = new ArrayList<String>();

    for (int i = 0; i < userInput.length(); i++) {
      for (int n = 0; n < 26; n++) {
        String t = userInput.substring(0, i) + alphabet[n] + userInput.substring(i + 1);
        if (words.contains(t) && !substitutionWords.contains(t)) {
          substitutionWords.add(t);
        }
      }
    }
    return substitutionWords;
  }

  /**
   * return correctly spelled words by swapping two adjacent characters of the
   * mispelled word
   * 
   * @param userInput (required) a string to be checked for spelling
   * @return returns an ArrayList of correctly spelled words
   **/
  public ArrayList<String> transposition(String userInput) {
    ArrayList<String> transpositionWords = new ArrayList<String>();

    for (int i = 0; i < userInput.length() - 1; i++) {
      String t = userInput.substring(0, i) + userInput.charAt(i + 1) + userInput.charAt(i) + userInput.substring(i + 2);
      if (words.contains(t) && !transpositionWords.contains(t)) {
        transpositionWords.add(t);
      }
    }
    return transpositionWords;
  }

  /**
   * returns correctly spelled word by swapping two adjacent characters of the
   * mispelled word
   * 
   * @param userInput (required) a string to be checked for spelling
   * @return returns an ArrayList of correctly spelled words
   **/
  public ArrayList<String> split(String userInput) {
    ArrayList<String> splitWords = new ArrayList<String>();

    for (int i = 0; i < userInput.length(); i++) {
      String t = userInput.substring(0, i) + " " + userInput.substring(i);
      if (words.contains(userInput.substring(0, i)) && words.contains(userInput.substring(i))
          && !splitWords.contains(t)) {
        splitWords.add(t);
      }
    }
    return splitWords;
  }
}