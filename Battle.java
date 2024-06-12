/**
 * This class contains actions of a battle
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Battle {

  /**
   * manages battle instances and returns whether or not the game should exit.
   * @param player The player that is fighting
   * @param enemy The enemy that is fighting
   * @return Returns whether or not the game should exit
   */
  public static boolean battleInstance(Player player, String enemyName, int enemyHP, int[] enemyDamage) {

    int choice;
    int potChoice = -1;
    int damage = 0;
    int turnCycle = 0;
    boolean enemyAttackIsCharged = false;
    boolean healCancel = true;
    String enemyNameStartSentence = enemyName.substring(0,1).toUpperCase() + enemyName.substring(1);

    while (player.getHealth() > 0) {

      turnCycle++;
      
      System.out.println("You have " + player.getHealth() + " HP left.");
      System.out.println(enemyNameStartSentence + " has " + enemyHP + " HP left.");
      System.out.println("What will you do?");
      System.out.print("1. Attack   ");
      System.out.println("2. Heal");

      choice = Input.intCheck(1, 2);

      while (healCancel) {
      switch(choice) {
        case 1:
          damage = player.weapon.use();
          enemyHP -= damage;
          System.out.println("You dealt " + damage + " damage to " + enemyName + "!");
          break;

        case 2:
          
          System.out.println("You have " + player.getSmallHeals() + " basic potions left, and have " + player.getBigHeals() + " super potions left.");
          System.out.println("Which potion would you like to use?");
          System.out.println("1. Basic Potion   2. Super Potion   3. Cancel");

          potChoice = Input.intCheck(1, 3);

          switch(potChoice) {

            case 1:
              if (player.getSmallHeals() > 0){
                player.setSmallHeals(player.getSmallHeals() - 1);
                player.setHealth(player.getHealth() + 20);
                System.out.println("You used a basic potion and healed 20 HP!");
              } 
              else {
                System.out.println("You don't have any basic potions left!");
                healCancel = true;
              }
              break;

            case 2:
              if (player.getBigHeals() > 0){
                player.setBigHeals(player.getBigHeals() - 1);
                player.setHealth(player.getHealth() + 45);
                System.out.println("You used a super potion and healed 45 HP!");
              } 
              else {
                System.out.println("You don't have any super potions left!");
                healCancel = true;
              }
              break;

            case 3:
              healCancel = true;
              break;
          }

          break;
      }
      }

      if (enemyHP <= 0){
              System.out.println("You defeated " + enemyName + "!");
              return false;
      }

      boolean enemyLandsHit = Math.random() > player.weapon.getEvasionOdds();
      
      if (turnCycle % 4 == 0) {
        System.out.println(enemyNameStartSentence + " is charging up a powerful attack...");
        enemyAttackIsCharged = true;
      }
        
      else if (enemyLandsHit) { //TODO remove nesting somehow (invert logic?)
        
        if (enemyAttackIsCharged) { //TODO suggest inversion logic
            System.out.println(enemyNameStartSentence + " unleashes a powerful attack!\nIt deals " + enemyDamage[1] + " damage to you!");
            player.setHealth(player.getHealth() - enemyDamage[1]);
            enemyAttackIsCharged = false;
        }

        else {
          System.out.println(enemyNameStartSentence + " attacks you, and deals " + enemyDamage[0] + " damage to you!");
        }
      }
    }
    
    System.out.println("You died!");
    return true;
  }
}