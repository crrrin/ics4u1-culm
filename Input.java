import java.util.Scanner;

/**
 * Utility class dealing with input and output methods for the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */
class Input {
  static Scanner sc = new Scanner(System.in);

  /**
   * Takes in a string input from the player
   * @return The string input from the player
   */
  public static String strIn() {
    Input.dialogue("Enter a valid string: ");
    String str = sc.nextLine();
    return str;
  }

  /**
   * Takes in an integer input from the player
   * @return The integer input from the player
   */
  public static int intIn() {
    int in = -1;
    boolean valid = false;

    //loop until valid input is given
    while (!valid) {
      Input.dialogue("Enter a valid integer: ");

      //try-catch block to catch invalid inputs
      try {
        in = sc.nextInt();
        valid = true;
      }
        
      catch (Exception e) {
        Input.dialogueln("Invalid input");
      }  

      //clears scanner
      finally {
        sc.nextLine();
      }
    }
    return in;
  }

  /**
   * Creates the main menu for the player to access various parts of the game
   */
  public static void mainMenu() {
    boolean stay = true;
    
    final String NAME_ASCII_ART = 
      "`'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='``'-.,_,.-+'``'-.,_,.='``'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='``'-.,_,.-'``'-.,_,.='`" + "\n\n" +
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

    lore("Welcome to the text-based adventure game, 'Immortal Quest', where you must survive a dangerous journey to retrieve an invaluable artifact.");
    clearConsole();

    //loops until the player quits the program
    while (stay) {
      System.out.println(
        "Select an option:\n" + 
        "1. Play game\n" + 
        "2. Leaderboard\n" + 
        "3. Personal Statistics\n" + 
        "4. Quit");
      int choice = intCheck(1, 4);
      System.out.println();

      //switch statement to handle the player's choice
      switch (choice) {
        case 1: 
          Player player = null;
          Game game = null;
          
          Input.dialogueln("Please enter your username (case sensitive, any spaces will be removed)");
          String username = "";

          //loops until a username with valid characters is given
          while (username.equals("")) {
            username = strIn().replaceAll(" ", "");
          }
          
          System.out.println("\n" + 
            "Choose an option:\n" + 
            "1. New game\n" + 
            "2. Load game (must be an existing player)");
          int gameChoice = intCheck(1, 2);

          //new game
          if (gameChoice == 1) {
            player = new Player(username);
            clearConsole(); 

            game = new Game(player);
            game.firstPlay();

            clearConsole();
          }

          //load game
          else {
            Data.loadData();

            //sequentially searches for a player with the given username in the database
            for (int i = 0; i < Data.players.size(); i++) {

              //player exists
              if (Data.players.get(i).getUsername().equals(username)) {
                player = Data.players.get(i);
                i = Data.players.size(); //exits for loop
              }
            }

            //player does not exist or does not have a saved game
            if (player == null || player.getEventsPassed() == 0) {
              System.out.println("\nYou do not have an existing game. Returning to main menu.\n");

              Sleep.wait(Sleep.LONG_DELAY);
              clearConsole();
            }

            //game loaded
            else {
              game = new Game(player);
            }
            
            game.play();
            dialogueln("Returning to main menu...");
          }
          break;

        case 2: 
          Data.leaderboard();
          break;

        case 3:
          Data.personalStats();
          break;

        case 4:
          dialogueln("Thanks for playing!");
          stay = false; //quits out of main menu
          break;
      }
      System.out.println();
    }
  }
   
  /**
   * Prints given prompt for the player to read character by character smoothly
   * @param prompt The text to be displayed to the player
   */
  public static void dialogue(String prompt) {

    //iterates through prompt to print 1 character at a time
    for (int i = 0; i < prompt.length(); i++) {
      System.out.print(prompt.charAt(i));
      Sleep.wait(Sleep.TINY_DELAY); 
    }
  }

  /**
   * Prints given prompt for the player to read character by character smoothly, with a new line at the end
   * @param prompt The text to be displayed to the player
   */
  public static void dialogueln(String prompt) {
    dialogue(prompt);
    System.out.println();
  }
  
  /**
   * Prints given prompt for the player to read character by character smoothly, and waits for the player to hit enter afterwards
   * @param prompt The text to be displayed to the player
   */
  public static void lore(String prompt) {
    dialogueln(prompt);
    System.out.println();
    Input.dialogue("Press ENTER to continue: ");
    
    sc.nextLine(); //enter check
    System.out.println();
  }

  /**
   * Gets an integer input from the player within the given range
   * @param minValue The minimum value that should be accepted
   * @param maxValue The maximum value that should be accepted
   */
  public static int intCheck(int minValue, int maxValue) {
    int choice = -1;

    //loops until a valid input is given
    while (choice > maxValue || choice < minValue) {
      choice = Input.intIn();
    }
    System.out.println();
    
    return choice;
  }
  
  /**
   * Clears the console of all previous text
   */
  public static void clearConsole() {
    System.out.print("\033[H\033[2J");  
    System.out.flush(); 
  }
}