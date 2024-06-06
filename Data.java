import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The class to store data of the player
 * 
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */
class Data {

  protected static ArrayList<Player> players;

  /**
   * Loads data from a text file.
   */
  public static void loadData() {
    Scanner databaseReader = null; //initialize outside try/catch
    try {
      databaseReader = new Scanner(new BufferedReader(new FileReader("Database.txt")));
      while (databaseReader.hasNext()) {
        // loads from database file in the format:
        // username(String) eventsPassed(int) money(int) playthroughs(int) gamesWon(int)
        Player player = new Player(databaseReader.next(), databaseReader.nextInt(), databaseReader.nextInt(), databaseReader.nextInt(), databaseReader.nextInt());
        players.add(player);
      }
    } 
    catch (IOException e) {
      System.out.println("Error reading file"); // TODO remove later
    } 
    finally {
      if (databaseReader != null) {
        databaseReader.close();
      }
    }
  }

  /**
   * Saves data to a text file.
   */
  public static void saveData() {
    PrintWriter databaseWriter = null; //initialize outside of try/catch
    try {
      databaseWriter = new PrintWriter(new BufferedWriter(new FileWriter("Database.txt")));
      for(int i = 0; i < players.size(); i++) {
        databaseWriter.println(players.get(i).getUsername() + " " + players.get(i).getEventsPassed() + " " + players.get(i).getMoney() + " " + players.get(i).getPlaythroughs() + " " + players.get(i).getGamesWon());
      }
    }
    catch (IOException e) {
      System.out.println("Error writing file"); // TODO remove later
    } 
    finally {
      if (databaseWriter != null) {
        databaseWriter.close();
      }
    }
  }

  /**
   * Adds a given player to the database; if the player already exists, it will update the stats of the player.
   * @param player The player to be added
   */
  public static void addPlayer(Player player) {
    boolean exists = false;
    for (int i = 0; i < players.size(); i++) {
      if (players.get(i).equals(player)) {
        players.get(i).setEventsPassed(player.getEventsPassed());
        players.get(i).setMoney(player.getMoney());
        exists = true;
        i = players.size();
      }
    }
    
    if (!exists) {
      players.add(player);
    }
  }
}