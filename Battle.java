/**
 * This class contains actions of a battle
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */

class Battle {
  
  /**
   * Runs a battle instance and returns whether or not the player dies
   * @param player The player that is fighting
   * @param enemyName The name of the enemy being fought
   * @param enemyHP The total health of the enemy
   * @param enemyDamage Array containing possible amounts of damage the enemy does - the first index contains their normal damage, while the second index contains their damage after a charged attack
   * @return Returns true if the player dies, false otherwise
   */
  public static boolean battleInstance(Player player, String[] enemy) {
    String enemyName = enemy[0];
    int enemyHP = Integer.parseInt(enemy[1]);
    int enemyBasicDamage = Integer.parseInt(enemy[2]);
    int enemyEnhancedDamage = Integer.parseInt(enemy[3]);
    int enemyBaseDrop = Integer.parseInt(enemy[4]);
      
    int choice, potChoice;
    int damage = -1;
    int turnCycle = 0;
    boolean enemyAttackIsCharged = false;
    boolean loopBack;

    // the money the enemy drops ranges from 80-120 percent of the base drop amount
    int moneyDropped = (int) ((enemyBaseDrop * 0.8) + (Math.random() * 0.4));
    
    String enemyNameStartSentence = enemyName.substring(0,1).toUpperCase() + enemyName.substring(1); //capitalizes first letter, used when sentence starts with enemy name

    //runs battle while player is alive
    while (player.getHealth() > 0) {

      loopBack = true;
      turnCycle++;

      //runs player's turn until a decision has been made
      while (loopBack) {
        
        System.out.println(
          "You have " + player.getHealth() + " HP left.\n" + 
          enemyNameStartSentence + " has " + enemyHP + " HP left.\n\n" + 
          "What will you do?\n" +
          "1. Attack   2. Heal\n");
        
        choice = Input.intCheck(1, 2); //gets input between 1 and 2

        //damages enemy if player chooses to attack, gives player choices to heal if they choose to heal
        switch (choice) {

          //attack
          case 1:
            damage = player.weapon.use(); //gets damage dealt by weapon
            enemyHP -= damage;
            
            Input.lore("You dealt " + damage + " damage to " + enemyName + "!");
            
            loopBack = false; //exits player's turn
            break;

          //heal menu
          case 2:
            System.out.println(
              "\nYou have " + player.getSmallHeals() + " basic potions left, and have " + player.getBigHeals() + " super potions left.\n" + 
              "Which potion would you like to use?\n" + 
              "1. Basic Potion   2. Super Potion   3. Cancel\n");
  
            potChoice = Input.intCheck(1, 3); //gets input between 1 and 3
            System.out.println();

            //if player chooses to use basic or super potion, uses the potion if they have any left, otherwise loops back to start of player's turn
            switch (potChoice) {

              //basic potion
              case 1:
                
                //checks if player has any basic potions left, uses 1 if they do
                if (player.getSmallHeals() > 0) {
                  player.setSmallHeals(player.getSmallHeals() - 1);
                  player.setHealth(player.getHealth() + 20);
                  Input.lore("You used a basic potion and healed 20 HP!");
                  damage = -1;
                  loopBack = false; //exits player's turn
                } 

                //player has no basic potions left
                else {
                  Input.lore("You don't have any basic potions left!");
                  loopBack = true; //loops back to start of player's turn
                }
              break;

            //super potion
            case 2:

              //checks if player has any super potions left, uses 1 if they do
              if (player.getBigHeals() > 0) {
                player.setBigHeals(player.getBigHeals() - 1);
                player.setHealth(player.getHealth() + 45);
                Input.lore("You used a super potion and healed 45 HP!");
                damage = -1;
                loopBack = false;
              } 

              //player has no super potions left
              else {
                Input.lore("You don't have any super potions left!");
                loopBack = true;
              }
              break;

            //exits out of heal menu, loops back to start of player's turn
            case 3:
              loopBack = true;
              break;
          }
          break;
        }
      }
      
      //checks if enemy is dead after attack
      if (enemyHP <= 0) {
        Input.lore("You defeated " + enemyName + "!");

        Input.lore("The enemy dropped " +  "You gained $" + moneyDropped + "!");
        player.setMoney(player.getMoney() + moneyDropped);
        return false; //exits battle
      }

      boolean enemyLandsHit = Math.random() > player.weapon.getEvasionOdds(); //if true, enemy lands a hit, else, enemy misses
      double enemyMultiplier = 1.00; // base enemy damage multiplier 

      //checks if player landed their hit (broadsword attack can miss), in which case enemy does more damage
      if (damage == 0) {
        enemyMultiplier = 1.75;
      }

      //on every 4th turn, enemy doesn't attack, and charges a powerful attack instead
      if (turnCycle % 4 == 0) {
        System.out.println(enemyNameStartSentence + " is charging up a powerful attack...");
        enemyAttackIsCharged = true;
      }

      //if enemy is not charging attack, and lands their hit, enemy does damage to player
      else if (enemyLandsHit) { 

        //charged attack
        if (enemyAttackIsCharged) {
          System.out.println(enemyNameStartSentence + " unleashes a powerful attack!\nIt deals " + (int) (enemyEnhancedDamage * enemyMultiplier) + " damage to you!");
          player.setHealth(player.getHealth() - (int) (enemyEnhancedDamage * enemyMultiplier));
          enemyAttackIsCharged = false;
        }

        //regular attack
        else {
          System.out.println(enemyNameStartSentence + " attacks you, and deals " + (int) (enemyBasicDamage * enemyMultiplier) + " damage to you!");
          player.setHealth(player.getHealth() - (int) (enemyBasicDamage * enemyMultiplier));
        }
      }

      else { // if the enemy misses their attack, they don't do any damage to the player
        System.out.println(enemyNameStartSentence + " missed their attack!");
        
      }
    }
    
    //if while loop ends, player has 0 HP, so player dies
    Input.lore("\nYou died!");
    return true;
  }
}