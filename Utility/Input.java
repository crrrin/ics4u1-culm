import java.util.Scanner;
/**
 * A class to take in input from the user
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
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
   * Creates the main menu for the user to access.
   */
  public static void mainMenu() {
    boolean stay = true;
    final String NAME_ASCII_ART = 
      "`'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='`" + "\n\n" +
      "`7MMF\'                                                      mm            `7MM        .g8\"\"8q.                                 mm" + "\n" +
      "  MM                                                        MM              MM      .dP\'    `YM.                               MM" + "\n" +
      "  MM  `7MMpMMMb.pMMMb.  `7MMpMMMb.pMMMb.  ,pW\"Wq.`7Mb,od8 mmMMmm  ,6\"Yb.    MM      dM\'      `MM `7MM  `7MM  .gP\"Ya  ,pP\"Ybd mmMMmm" + "\n" +
      "  MM    MM    MM    MM    MM    MM    MM 6W\'   `Wb MM\' \"\'   MM   8)   MM    MM      MM        MM   MM    MM ,M\'   Yb 8I   `\"   MM" + "\n" +
      "  MM    MM    MM    MM    MM    MM    MM 8M     M8 MM       MM    ,pm9MM    MM      MM.      ,MP   MM    MM 8M\"\"\"\"\"\" `YMMMa.   MM" + "\n" +
      "  MM    MM    MM    MM    MM    MM    MM YA.   ,A9 MM       MM   8M   MM    MM      `Mb.    ,dP\'   MM    MM YM.    , L.   I8   MM" + "\n" +
      ".JMML..JMML  JMML  JMML..JMML  JMML  JMML.`Ybmd9\'.JMML.     `Mbmo`Moo9^Yo..JMML.      `\"bmmd\"\'     `Mbod\"YML.`Mbmmd\' M9mmmP\'   `Mbmo" + "\n" +
      "                                                                                          MMb" + "\n" +
      "                                                                                           `bood\'" + "\n" +
      "`'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='`";



    System.out.println("\n" + NAME_ASCII_ART + "\n");

    Input.lore("Welcome to the text-based adventure game, 'Immortal Quest', where you must survive a dangerous journey to retrieve an invaluable artifact.");

    Input.clearConsole();

    while (stay) {
      System.out.println("Select an option:\n1. Play game\n2. Leaderboard\n3. Personal Statistics\n4. Quit");
      int choice = Input.intCheck(1, 4);
      System.out.println();

      switch (choice) {
        case 1: 
          System.out.println("Please enter your username (case sensitive, any spaces will be removed)");
          String username = "";
          while (username.equals("")) {
            username = Input.strIn().replaceAll(" ", "");
          }
          System.out.println("\nChoose an option:\n1. New game\n2. Load game (must be an existing user)");
          int gameChoice = Input.intCheck(1, 2);
          Player player = null;
          if (gameChoice == 1) {
            player = new Player(username);

          Input.clearConsole(); 

            Game game = new Game(player);
            game.firstPlay();

            Input.clearConsole();

            game.play();
          }
          else {
            Data.loadData();
            for (int i = 0; i < Data.players.size(); i++) {
              if (Data.players.get(i).getUsername().equals(username)) {
                player = Data.players.get(i);
                i = Data.players.size();
              }
            }
            if (player == null || player.getEventsPassed() == 0) {
              System.out.println("\nYou do not have an existing game. Returning to main menu.\n");

              Sleep.wait(Sleep.LONG_DELAY);
              Input.clearConsole();
            }
            else {
              Game game = new Game(player);
              game.play();
            }
          }
          break;

        case 2: 
          Data.leaderboard();
          break;

        case 3:
          Data.personalStats();
          break;

        case 4: //quit
          Input.dialogueln("Thanks for playing!");
          stay = false;
          // TODO potentially make stay global?
          break;
      }
      System.out.println();
    }
  }
  
  
  /**
   * This method prints the text for the player to read character by character smoothly
   * @param prompt The text to be displayed to the user
   */
  public static void dialogue(String prompt) {

    for (int i = 0; i < prompt.length(); i++) {
      System.out.print(prompt.charAt(i));
      Sleep.wait(Sleep.TINY_DELAY); 
    }

  }

  /**
   * This method prints the text for the player to read character by character smoothly, with a newline character
   * @param prompt The text to be displayed to the user
   */
  public static void dialogueln(String prompt) {

    for (int i = 0; i < prompt.length(); i++) {
      System.out.print(prompt.charAt(i));
      Sleep.wait(Sleep.TINY_DELAY); 
    }

    System.out.println();

  }
  
  /**
   * This method prints the text for the player to read character by character smoothly, and waits for the player to hit enter afterwards
   * @param prompt The text to be displayed to the user
   */
  public static void lore(String prompt) {
    
    dialogueln(prompt);
    
    System.out.println();
    System.out.print("Press ENTER to continue: ");
    sc.nextLine();
    
    System.out.println();
  }

  public static int intCheck(int minValue, int maxValue) {
    int choice = -1;
    
    while (choice > maxValue || choice < minValue) {
      choice = Input.intIn();
    }
    System.out.println();
    
    return choice;
  }
  
  //clearing console is inherently an os thing
  public static void clearConsole() {
    System.out.print("\033[H\033[2J");  
    System.out.flush(); 
  }
  
}
