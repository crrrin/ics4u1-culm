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

    int choice;
    int potChoice = -1;
    int damage = 0;
      
    preChoice:
    
    while (enemyHP > 0){
      
      
      System.out.println("You have " + player.getHealth() + " HP left.");
      System.out.println("The " + enemyName + " has " + enemyHP + " HP left.");
      System.out.println("What will you do?");
      System.out.print("1. Attack   ");
      System.out.println("2. Heal");

      choice = -1;
      
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
          System.out.println("You have " + player.getSmallHeals() + " basic potions left, and have " + player.getBigHeals() + " super potions left.");
          System.out.println("Which potion would you like to use?");
          System.out.println("1. Basic Potion   2. Super Potion   3. Cancel");

          potChoice = -1;
          
          while (potChoice != 1 && potChoice != 2 && potChoice != 3){
            potChoice = Input.intIn();
          }
          
          switch(potChoice){
            case 1:
              if (player.getSmallHeals() > 0){
                player.setSmallHeals(player.getSmallHeals() - 1);
                player.setHealth(player.getHealth() + 20);
                System.out.println("You used a basic potion and healed 20 HP!");
              } else {
                System.out.println("You don't have any basic potions left!");
              }
              break;
            case 2:
              if (player.getBigHeals() > 0){
                player.setBigHeals(player.getBigHeals() - 1);
                player.setHealth(player.getHealth() + 45);
                System.out.println("You used a super potion and healed 45 HP!");
              } else {
                System.out.println("You don't have any super potions left!");
              }
              break;
            case 3:
              break preChoice;
          }
          
          break;
      }

      
    }
  }

  

  
}