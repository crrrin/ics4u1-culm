/**
 * Object containing actions of a sword in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */

class Sword implements Weapon {

  protected final int DAMAGE = 20;
  protected final double CRIT_ODDS = 0.3;
  protected final double MIN_CRIT_MULTI = 1.5;
  protected final double MAX_CRIT_MULTI = 2.0;
  protected final double EVASION_ODDS = 0;
  protected int critDamage;
  
  /**
   * Uses the sword
   * @return The damage value after crit hit calculations, if the weapon landed the crit
   */
  @Override
  public int use() {
    boolean crit = Math.random() < CRIT_ODDS; //true if the sword lands a crit
    
    Input.dialogueln("You swing your sword.");
    Sleep.wait(Sleep.LONG_DELAY);

    //returns crit damage if the sword lands a crit
    if (crit) {
      this.critDamage = (int) Math.round(this.DAMAGE * (Math.random() * (this.MAX_CRIT_MULTI - this.MIN_CRIT_MULTI) + this.MIN_CRIT_MULTI));
      Input.dialogueln("CRITICAL HIT!"); 

      return this.critDamage;
    } 
    
    //returns base damage if the sword does not land a crit
    else {
      return this.DAMAGE;
    }
  }

  /**
   * Contains a description of the sword 
   * @return A string with the description of the sword
   */
  public static String description() {
    return "Forged by skilled blacksmiths, the sword is a long and deadly weapon.\nDeals a humble 8 damage, but has a 30% chance to deal a critial hit.\nCritical hits deal +150-200% damage.\nFavoured by renowned knights of the kingdom, it is the weapon that the king has graced you with as you set out on this journey.";
  }
  
  /** 
   * Returns the name of the weapon
   * @return A string with the weapon name
   */
  @Override
  public String toString() {
    return "Sword";
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