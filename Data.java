import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
* The class to store data of the player
* @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
* @version 17.0.5
* @since 2024/06/12
*/
class Data {

  protected ArrayList<Player> players;
  
  /**
   * Sets the username of the user to the given username
   * @param username String containing the user's given username
   */
  public void Data(String username){
    this.username = username;
  }

  /**
   * loads data from the file into 
   * @param username String containing the user's given username
   */
  public void loadData() {
    try {
     Scanner databaseReader = new Scanner(new BufferedReader(new FileReader("Database.txt")))
    }
    catch (IOException e) {
      System.out.println("Error reading file");
    }
    finally {
      if(databaseReader != null) {
        databaseReader.close();
      }
    }
  }

 
  
  public void saveData() {
    
  }
}