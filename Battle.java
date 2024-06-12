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
    boolean loopBack = true;
    String enemyNameStartSentence = enemyName.substring(0,1).toUpperCase() + enemyName.substring(1);

    while (player.getHealth() > 0) {

      loopBack = true;

      turnCycle++;
      


      while (loopBack) {
        System.out.println();
        System.out.println("You have " + player.getHealth() + " HP left.");
        System.out.println(enemyNameStartSentence + " has " + enemyHP + " HP left.");
        System.out.println();
        System.out.println("What will you do?");
        System.out.print("1. Attack   ");
        System.out.println("2. Heal");
        System.out.println();
        
        choice = Input.intCheck(1, 2);
          
        switch(choice) {
          case 1:
            damage = player.weapon.use();
            enemyHP -= damage;
            System.out.println("You dealt " + damage + " damage to " + enemyName + "!");
            loopBack = false;
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
                  loopBack = false;
                } 
                else {
                  System.out.println("You don't have any basic potions left!");
                  loopBack = true;
                }
                break;
  
              case 2:
                if (player.getBigHeals() > 0){
                  player.setBigHeals(player.getBigHeals() - 1);
                  player.setHealth(player.getHealth() + 45);
                  System.out.println("You used a super potion and healed 45 HP!");
                  loopBack = false;
                } 
                else {
                  System.out.println("You don't have any super potions left!");
                  loopBack = true;
                }
                break;
  
              case 3:
                loopBack = true;
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
      
      boolean enemyBonus = Math.random() > player.weapon.getEnemyBonus();

      double enemyMultiplier = 1.00; // base enemy damage multiplier 
      
      if (damage != 0) { // if the broadsword attack missed, the enemy deals bonus damage
        enemyMultiplier = 1.75;
      }
      
      if (turnCycle % 4 == 0) {
        System.out.println(enemyNameStartSentence + " is charging up a powerful attack...");
        enemyAttackIsCharged = true;
      }
        
      else if (enemyLandsHit) { //TODO remove nesting somehow (invert logic?)
        
        if (enemyAttackIsCharged) { //TODO suggest inversion logic //powerful hit
            System.out.println(enemyNameStartSentence + " unleashes a powerful attack!\nIt deals " + ((int) enemyDamage[1] * enemyMultiplier) + " damage to you!");
            player.setHealth(player.getHealth() - ((int) (enemyDamage[1] * enemyMultiplier)));
            enemyAttackIsCharged = false;
        }

        else { //normal hit
          System.out.println(enemyNameStartSentence + " attacks you, and deals " + (int) enemyDamage[0]*enemyMultiplier + " damage to you!");
          player.setHealth(player.getHealth() - ((int) (enemyDamage[0] * enemyMultiplier)));
        }
      }
    }
    
    System.out.println("You died!");
    return true;
  }
}