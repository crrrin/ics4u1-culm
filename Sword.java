/**
 * Object containing actions of a sword in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/14
 */

class Sword implements Weapon {

  protected static final int DAMAGE = 20;
  protected static final double CRIT_ODDS = 0.3;
  protected static final double MIN_CRIT_MULTI = 1.5;
  protected static final double MAX_CRIT_MULTI = 2.0;
  protected final double EVASION_ODDS = 0;
  protected int critDamage;
  protected static final int PRICE = 80;
  
  /**
   * Uses the sword
   * @return The damage value after crit hit calculations, if the weapon landed the crit
   */
  @Override
  public int use() {
    boolean crit = Math.random() < CRIT_ODDS; //true if the sword lands a crit
    
    GameIO.dialogueln("You swing your sword.");
    GameIO.wait(GameIO.LONG_DELAY);

    //returns crit damage if the sword lands a crit
    if (crit) {
      this.critDamage = (int) Math.round(DAMAGE * (Math.random() * (MAX_CRIT_MULTI - MIN_CRIT_MULTI) + MIN_CRIT_MULTI));
      GameIO.dialogueln("CRITICAL HIT!"); 

      return this.critDamage;
    } 
    
    //returns base damage if the sword does not land a crit
    else {
      return DAMAGE;
    }
  }

  /**
   * Contains a description of the sword 
   * @return A string with the description of the sword
   */
  public static String description() {
    return 
      "Forged by skilled blacksmiths, the sword is a long and deadly weapon.\n" + 
      "Deals " + DAMAGE + " damage, but has a " + (int) (Math.round(CRIT_ODDS * 100)) + "% chance to deal a critial hit.\n" + 
      "Critical hits deal +" + (int) (Math.round(MIN_CRIT_MULTI * 100)) + "-" + (int) (Math.round(MAX_CRIT_MULTI * 100)) + "% damage.\n" + 
      "Favoured by renowned knights of the kingdom, it is the weapon that the king has graced you with as you set out on this journey.";
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
  public double getEvasionOdds() {
    return this.EVASION_ODDS;
  }

  /** 
   * Returns the price of the weapon
   * @return An int with the price of the weapon
   */
  public static int getPrice() {
    return PRICE;
  }
}