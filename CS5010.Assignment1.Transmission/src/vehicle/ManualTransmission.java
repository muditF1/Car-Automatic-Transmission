package vehicle;

/**
 * This is an interface for manual transmission which represents the vehicle and it's details about
 * things like status, speed, gear as well as operations of increasing/decreasing gear and speed.
 */
public interface ManualTransmission {
  /**
   * Return the status of this transmission as a String. Status is the current state of the vehicle
   * and its capabilities of what the vehicle can do at a given moment. Status will refer to
   * following things in our current context: “OK: everything is OK.”: this is the status if the
   * speed was changed successfully without changing gears, or the gear was changed successfully
   * without changing speed.
   * 1.“OK: you may increase the gear.”: this is the status if the speed was increased
   * successfully, but it is now within the range of the next gear (remember that adjacent gear
   * ranges may overlap)
   * 2. “OK: you may decrease the gear.”: this is the status if the speed was decreased
   * successfully, but it is now within the range of the previous gear (remember that adjacent gear
   * ranges may overlap)
   * 3.“Cannot increase speed, increase gear first.”: this is the status if the speed cannot be
   * increased more unless the gear is increased first. This implies that the intended speed is too
   * high for the current gear.
   * 4.“Cannot decrease speed, decrease gear first.”: this is the status if the speed cannot be
   * decreased more unless the gear is decreased first. This implies that the intended speed is too
   * low for the current gear.
   * 5.“Cannot increase gear, increase speed first.”: this is the status if the gear cannot be
   * increased more unless the speed is increased first. This implies that the current speed will be
   * too low for the next gear.
   * 6.“Cannot decrease gear, decrease speed first.”: this is the status if the gear cannot be
   * decreased more unless the speed is decreased first. This implies that the current speed will be
   * too high for the previous gear.
   * 7.“Cannot increase speed. Reached maximum speed.”: this is the status if the speed cannot be
   * increased as it will go beyond the speed limit of the vehicle
   * 8.“Cannot decrease speed. Reached minimum speed.”: this is the status if the speed cannot be
   * decreased as it is already 0
   * 9.“Cannot increase gear. Reached maximum gear.”: this is the status if the gear cannot be
   * increased as it is already in gear 5
   * 10.“Cannot decrease gear. Reached minimum gear.”: this is the status if the gear cannot be
   * decreased as it is already in gear 1
   *
   * @return returns the current status of the manual transmission.
   */
  String getStatus();

  /**
   * Return the current speed of the vehicle as a whole number.
   *
   * @return returns the current speed of the vehicle as a whole number.
   */
  int getSpeed();

  /**
   * Return the current gear vehicle is in.
   *
   * @return returns the current gear in which vehicle is as a whole number.
   */
  int getGear();

  /**
   * Increases the speed of the vehicle. Amount of speed increase can be 1 at a time. Maximum speed
   * will be the highest speed of the 5th gear, it should be input by the user.
   *
   * @return the transmission object, in case the speed cannot be increased, returns the
   *     transmission object with the same speed as it was earlier.
   */
  ManualTransmission increaseSpeed();

  /**
   * Decrease the speed of the vehicle. Amount of speed decrease can be 1 at a time.
   *
   * @return the transmission object, in case the speed cannot be decreased, returns the
   *     transmission object with the same speed as it was earlier. Minimum speed will be 0.
   */
  ManualTransmission decreaseSpeed();

  /**
   * Increase the gear in the transmission of the vehicle by 1 without changing the speed of the
   * vehicle. Starting gear of the transmission would be 1 and last gear of the transmission is 5,
   * it should be not allowed to go beyond it.
   *
   * @return the transmission object, in case the gear cannot be increased, returns the transmission
   *     object with the same speed as it was earlier.
   */
  ManualTransmission increaseGear();

  /**
   * Decrease the gear in the transmission of the vehicle by 1 without changing the speed of the
   * vehicle. Highest gear of the transmission should be 5 abd initial gear is 1, it should not be
   * allowed to go below it.
   *
   * @return the transmission object, in case the gear cannot be decreased, returns the transmission
   *     object with the same speed as it was earlier.
   */
  ManualTransmission decreaseGear();
}
