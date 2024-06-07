/**
 * This class contains actions of a battle
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Battle {

  /**
   * Contains information and prompts of a battle
   */
  public static void battleInstance(Player player, String enemyName, int enemyHP){

    int choice = -1;
    int damage = 0;
    
    while (enemyHP > 0){
      
      System.out.println("You have " + player.getHealth() + " HP left.");
      System.out.println("The " + enemyName + " has " + enemyHP + " HP left.");
      System.out.println("What will you do?");
      System.out.print("1. Attack   ");
      System.out.println("2. Heal");

      while (choice != 1 && choice != 2){
        choice = Input.intIn();
      }

      switch(choice){
        case 1:
          damage = player.weapon.use();
          enemyHP -= damage;
          System.out.println("You dealt " + damage + " damage to the " + enemyName + "!");
          break;
        case 2:
          //TODO healing system rework????
          break;
      }

      
    }
  }

  

  
}