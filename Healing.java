/**
 * This class contains actions related to healing items in the game
 * @author Shyamal Sriniketh, Ethan Duong, Dhanish Azam
 * @version 17.0.5
 * @since 2024/06/12
 */

class Healing {
  protected int value;

  /** 
   * Creates a healing item with a given value
   * @param value The value of the healing item
   */
  public Healing(int value) {
    this.value = value;
  }

  /** 
   * Uses a healing item
   * @param player The player using the healing item
   */
  public void use(Player player) {
    player.setHealth(player.getHealth() + value);
    //TODO stock_of_healing--;
  }

  /** 
   * Uses a quantity of a healing item
   * @param The player using the healing item
   * @param quantity The quantity of the healing item to be used
   */
  public void use(Player player, int quantity) {
    player.setHealth(player.getHealth() + value * quantity);
    //TODO stock_of_healing -= quantity;
  }
}