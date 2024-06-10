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

  public static void lore(String prompt) {
    System.out.println("\n" + prompt);
    System.out.print("Press enter to continue: ");
    sc.nextLine();
  }
}