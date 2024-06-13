import java.util.Scanner;
/**
 * A class to take in input from the user
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Input {
  static Scanner sc = new Scanner(System.in);

  /**
   * Takes in a string input from the user
   * @return The string input from the user
   */
  public static String strIn() {
    System.out.print("Enter a valid string: ");
    String str = sc.nextLine();
    return str;
  }

  /**
   * Takes in an integer input from the user
   * @return The integer input from the user
   */
  public static int intIn() {
    int in = -1;
    boolean valid = false;
    while (!valid) {
      System.out.print("Enter a valid integer: ");
      try {
        in = sc.nextInt();
        valid = true;
      }
      catch (Exception e) {
        System.out.println("Invalid input");
      }  
      finally {
        sc.nextLine();
      }
    }
    return in;
  }

  /**
   * This method prints the text for the player to read character by character smoothly
   * @param prompt The text to be displayed to the user
   */
  public static void lore(String prompt) {
    
    System.out.println("\n");
    
    // for (int i = 0; i < prompt.length(); i++) {
    //   System.out.print(prompt.charAt(i));
    //   Sleep.wait(Sleep.TINY_DELAY); 
    // }

    System.out.print(prompt);
    
    System.out.println("\n");
    System.out.print("Press ENTER to continue: ");
    sc.nextLine();
    
    System.out.println("\n");
  }

  public static int intCheck(int minValue, int maxValue) {
    int choice = -1;
    while (choice > maxValue || choice < minValue) {
      choice = Input.intIn();
    }
    return choice; // WE NEED A FLUSH METHOD AND SPACING THERE AFTER WELCOME TO THE GAME.
    //
  }
  //clearing console is inherently an os thing
  public static void clearConsole()  { //TODO UNIX FLUSH ASK KALISH ---> (pointing) ---> (pointing) ---> (pointing) ---> (pointing) ---> (pointing) ---> (pointing) ---> (pointing)
    String flushString = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"; 
    System.out.print(flushString + flushString + flushString + flushString); 
  }  

  public static void miniClear()  { //TODO UNIX FLUSH ASK KALISH ---> (pointing) ---> (pointing) ---> (pointing) ---> (pointing) ---> (pointing) ---> (pointing) ---> (pointing)
    String flushString = "\n\n\n\n\n\n"; 
    System.out.print(flushString); 
  }  

  
}
