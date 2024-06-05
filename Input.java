import java.util.Scanner;
class Input {
  static Scanner sc = new Scanner(System.in);
  
  public static String strIn() {
    System.out.print("Enter a valid string: ");
    String str = sc.nextLine();
    return str;
  }
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
}