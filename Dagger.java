/**
 * Object containing actions of a dagger in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */

class Dagger implements Weapon {
  
  protected final int DAMAGE = 12;
  protected final int MAX_BONUS_STRIKES = 5;
  protected final double MULTIHIT_ODDS = 0.5;
  protected final double EVASION_ODDS = 0;
  
  /**
   * Uses the dagger
   * @return The damage value after nulti hit calculations, if the weapon landed multiple hits
   */
  @Override
  public int use() {

    int bonusDamageInstances = 0;
    
    Input.dialogueln("You strike with your dagger.");
    
    Sleep.wait(Sleep.LONG_DELAY);

    //decides number of additional hits, runs until multihit odds are not met or maximum bonus strikes are reached
    for (double i = Math.random(); i < MULTIHIT_ODDS && bonusDamageInstances <= MAX_BONUS_STRIKES; i = Math.random()) {
      
      bonusDamageInstances++;

      //1 extra hit
      if (bonusDamageInstances == 1) {
        Input.dialogueln("MULTIHIT! " + bonusDamageInstances + " extra hit!");

        Sleep.wait(Sleep.SHORT_DELAY);

      }

      //more than 1 extra hit
      else if (bonusDamageInstances > 1) {
        Input.dialogueln("MULTIHIT! " + bonusDamageInstances + " extra hits!");
      }
      
      Sleep.wait(Sleep.SHORT_DELAY);
    }
    
    return this.DAMAGE + bonusDamageInstances * this.DAMAGE;
    
  }
  
  /**
   * Contains a description of the dagger 
   * @return A string with the description of the dagger
   */
  public static String description() {
    return "Used by assassins and the like, the dagger is a small, simple and agile weapon, yet a deadly one.\nDeals the lowest damage of the weapons at a measly 5 damage, but has a 50% chance to land an extra hit, up to a maximum of 5 extra hits.";
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
}