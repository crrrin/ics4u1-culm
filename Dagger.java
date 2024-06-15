/**
 * Object containing actions of a dagger in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */

class Dagger implements Weapon {
  
  protected static final int DAMAGE = 10;
  protected static final int MAX_BONUS_STRIKES = 5;
  protected static final double MULTIHIT_ODDS = 0.5;
  protected final double EVASION_ODDS = 0;
  protected static final int PRICE = 170;
  
  /**
   * Uses the dagger
   * @return The damage value after nulti hit calculations, if the weapon landed multiple hits
   */
  @Override
  public int use() {

    int bonusDamageInstances = 0;
    
    GameIO.dialogueln("You strike with your dagger.");
    
    GameIO.wait(GameIO.LONG_DELAY);

    //decides number of additional hits, runs until multihit odds are not met or maximum bonus strikes are reached
    for (double i = Math.random(); i < MULTIHIT_ODDS && bonusDamageInstances <= MAX_BONUS_STRIKES; i = Math.random()) {
      
      bonusDamageInstances++;

      //1 extra hit
      if (bonusDamageInstances == 1) {
        GameIO.dialogueln("MULTIHIT! " + bonusDamageInstances + " extra hit!");

        GameIO.wait(GameIO.SHORT_DELAY);

      }

      //more than 1 extra hit
      else if (bonusDamageInstances > 1) {
        GameIO.dialogueln("MULTIHIT! " + bonusDamageInstances + " extra hits!");
      }
      
      GameIO.wait(GameIO.SHORT_DELAY);
    }
    
    return DAMAGE + bonusDamageInstances * DAMAGE;
    
  }
  
  /**
   * Contains a description of the dagger 
   * @return A string with the description of the dagger
   */
  public static String description() {
    return 
      "Used by assassins and the like, the dagger is a small, simple and agile weapon, yet a deadly one.\n" + 
      "Deals the lowest damage of the weapons at a measly " + DAMAGE + " damage, but has a " + (int) (Math.round(100 * MULTIHIT_ODDS)) + "% chance to land an extra hit, up to a maximum of " + MAX_BONUS_STRIKES + " extra hits.";
  }

  /** 
   * Returns the name of the weapon
   * @return A string with the weapon name
   */
  @Override
  public String toString() {
    return "Dagger";
  }

  /** 
   * Returns the odds of evasion
   * @return A double with the odds of evasion
   */        
  @Override
  public double getEvasionOdds() {
    return EVASION_ODDS;
  }

  /** 
   * Returns the price of the weapon
   * @return An int with the price of the weapon
   */
  public static int getPrice() {
    return PRICE;
  }
}