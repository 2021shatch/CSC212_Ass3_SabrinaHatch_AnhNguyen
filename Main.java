/**
 * Class used to run spell checker program and tests, also prints instructions
 * on how to use the program to the console
 * 
 * @author Anh Nyguen & Sabrina Hatch
 * @version Spring 2022
 **/
class Main {
  /**
   * Run tests and spell checker
   **/
  public static void main(String[] args) {
    System.out.println("\n"
        + "Hello! Welcome to the Java Spell Checker! to check your words, either enter 'java SpellChecker' followed directly by the words you want to check, or use the following notation to read in a txt file: 'java SpellChecker < NAME_OF_FILE.txt'. Please make sure to type in an input before you hit enter or else the program will not work correctly! In that case, please restart the program and try again."
        + "\n");
    System.out.println("Initializing dictionary...");
    SpellDictionary dict = new SpellDictionary("words.txt");
    System.out.println("Finish initialisation.");
    testSpellDictionary(dict);
  }

  /**
   * runs tests for all of our submethods as well as our final nearMisses method &
   * tests our boolean containsWord method
   **/
  public static void testSpellDictionary(SpellDictionary dictionary) {
    TestCode.beginTest("Spell dictionary");
    TestCode.subTest("Near misses", dictionary.nearMisses("Baldwinx").contains("Baldwin"));
    TestCode.subTest("Deletion", dictionary.deletion("xBaldwin").contains("Baldwin"));
    TestCode.subTest("Insertion", dictionary.insertion("oblin").contains("goblin"));
    TestCode.subTest("Substitution", dictionary.substitution("toblin").contains("goblin"));
    TestCode.subTest("Transposition", dictionary.transposition("aBldwin").contains("Baldwin"));
    TestCode.subTest("Split", dictionary.split("tquest").contains("t quest"));
    TestCode.subTest("Contains word", dictionary.containsWord("goblin"));
    TestCode.concludeTest();

  }
}