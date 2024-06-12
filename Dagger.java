/**
 * This class contains actions of a dagger in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

// TODO change javadocs to match use

class Dagger implements Weapon {
  
  protected final int DAMAGE = 5;
  protected final int MAX_BONUS_STRIKES = 5;
  protected final double MULTIHIT_ODDS = 0.5;
  protected final double EVASION_ODDS = 0;
  protected final double ENEMY_BONUS_ODDS = 0;
  
  /**
   * Uses the dagger
   */
  @Override
  public int use() {

    int bonusDamageInstances = 0;
    
    System.out.println("You strike with your dagger.");
    
    Sleep.wait(Sleep.LONG_DELAY);

    for (Double i = Math.random(); i < MULTIHIT_ODDS && bonusDamageInstances <= MAX_BONUS_STRIKES; i = Math.random()){
      bonusDamageInstances++;

      if (bonusDamageInstances == 1){
        System.out.println("MULTIHIT! " + bonusDamageInstances + " extra hit!");

        Sleep.wait(Sleep.SHORT_DELAY);

      } else if (bonusDamageInstances > 1) {
        System.out.println("MULTIHIT! " + bonusDamageInstances + " extra hits!");
      }
      
      Sleep.wait(Sleep.SHORT_DELAY);
    }
    
    return this.DAMAGE + bonusDamageInstances * this.DAMAGE;
    
  }
  /**
   * Contains the description about the dagger 
   */
  public static String description() {
    return "Used by assassins and the like, the dagger is a small, simple and agile weapon yet a deadly weapon.\nDeals the lowest damage of the weapons at a measly 5 damage, but has 50% chance to land an extra hit, up to a maximum of 5 extra hits.\nThis is the starter weapon.";
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
  public double getEvasionOdds(){
    return EVASION_ODDS;
  }
}