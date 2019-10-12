package vehicle;

/**
 * This class implements the characteristics of the a manual transmission in a vehicle and it's
 * associated properties like gear/speed status, changing the gears and speed up and down. It also
 * defines various stages or status of the transmission at a given point after/before/during an
 * operation executed on the transmission, some of the properties are as below: 1. The speed changes
 * by 1 at a time. 2. Transmission with 5 gears, numbered 1 through 5, gear 1 being the lowest. 3.
 * Status message that the transmission can give at a point in time are : "OK: everything is OK",
 * "OK: you may increase the gear", "OK: you may decrease the gear", "Cannot increase speed,
 * increase gear first", "Cannot decrease speed, decrease gear first", "Cannot increase gear,
 * increase speed first", "Cannot decrease gear, decrease speed first", "Cannot increase speed.
 * Reached maximum speed", "Cannot decrease speed. Reached minimum speed", "Cannot increase gear.
 * Reached maximum gear", "Cannot decrease gear. Reached minimum gear"
 */
public class RegularManualTransmission implements ManualTransmission {
  private int currentSpeed;
  private int currentGear;
  private TransmissionStatus currentStatus;
  private int minSpeed;
  private int h1;
  private int l2;
  private int h2;
  private int l3;
  private int h3;
  private int l4;
  private int h4;
  private int l5;
  private int maxSpeed;

  /** enum to define the various transmission status. */
  private enum TransmissionStatus {
    OK("OK: everything is OK."),
    MAY_INCREASE_GEAR("OK: you may increase the gear."),
    MAY_DECREASE_GEAR("OK: you may decrease the gear."),
    NO_SPEED_INCREASE_INCREASE_GEAR("Cannot increase speed, increase gear first."),
    NO_SPEED_DECREASE_DECREASE_GEAR("Cannot decrease speed, decrease gear first."),
    NO_INCREASE_GEAR_INCREASE_SPEED("Cannot increase gear, increase speed first."),
    NO_DECREASE_GEAR_DECREASE_SPEED("Cannot decrease gear, decrease speed first."),
    MAX_SPEED("Cannot increase speed. Reached maximum speed."),
    MIN_SPEED("Cannot decrease speed. Reached minimum speed."),
    MAX_GEAR("Cannot increase gear. Reached maximum gear."),
    MIN_GEAR("Cannot decrease gear. Reached minimum gear.");

    String value;

    TransmissionStatus(String value) {
      this.value = value;
    }

    String getValue() {
      return value;
    }
  }

  /**
   * Constructor for initializing the gear speed ranges, starting gear to 1 and starting speed to
   * zero, max speed would be the value passed as the last variable in the constructor. Also setting
   * the default transmission status to "OK: everything is OK.". Exceptions in input values and
   * relational conditions of the input variables are also defined here.
   *
   * @param h1 Higher speed in Gear 1
   * @param l2 Lower speed in Gear 2
   * @param h2 Higher speed in Gear 2
   * @param l3 Lower speed in Gear 3
   * @param h3 Higher speed in Gear 3
   * @param l4 Lower speed in Gear 4
   * @param h4 Higher speed in Gear 4
   * @param l5 Lower speed in Gear 5
   * @param maxSpeed Maximum speed of the vehicle.
   */
  public RegularManualTransmission(
      int minSpeed, int h1, int l2, int h2, int l3, int h3, int l4, int h4, int l5, int maxSpeed) {
    currentSpeed = minSpeed;
    currentGear = 1;
    currentStatus = TransmissionStatus.OK;

    this.minSpeed = minSpeed;
    this.h1 = h1;
    this.l2 = l2;
    this.h2 = h2;
    this.l3 = l3;
    this.h3 = h3;
    this.l4 = l4;
    this.h4 = h4;
    this.l5 = l5;
    this.maxSpeed = maxSpeed;

    if (minSpeed != 0) {
      throw new IllegalArgumentException("Minimum speed has to be zero");
    } else if (h1 < 0
        || l2 < 0
        || h2 < 0
        || l3 < 0
        || h3 < 0
        || l4 < 0
        || h4 < 0
        || l5 < 0
        || maxSpeed < 0) {
      throw new IllegalArgumentException(
          "Speeds cannot be a negative value. Please input a " + "positive value for speed");
    } else if (minSpeed > h1 || l2 > h2 || l3 > h3 || l4 > h4 || l5 > maxSpeed) {
      throw new IllegalArgumentException("Higher gear speed cannot be less than lower gear speed");
    } else if (l2 > h1 || l3 > h2 || l4 > h3 || l5 > h4) {
      throw new IllegalArgumentException(
          "The speed ranges cannot be non-overlapping. Please "
              + "provide an overlapping speed ranges");
    } else if (minSpeed > l2 || l2 > l3 || l3 > l4 || l4 > maxSpeed) {
      throw new IllegalArgumentException(
          "Lower gear speed of a lower gear cannot be higher than the lower gear speed of a higher"
              + " gear. Please input the lower gear's slowest speed less than the"
              + " corresponding higher gear's lower speed.");
    }
  }

  @Override
  public String getStatus() {
    return currentStatus.getValue();
  }

  @Override
  public int getSpeed() {
    return currentSpeed;
  }

  @Override
  public int getGear() {
    return currentGear;
  }

  @Override
  public ManualTransmission increaseSpeed() {
    if (shouldUpdateSpeed(true)) {
      currentSpeed++;
    }
    return this;
  }

  @Override
  public ManualTransmission decreaseSpeed() {
    if (shouldUpdateSpeed(false)) {
      currentSpeed--;
    }
    return this;
  }

  @Override
  public ManualTransmission increaseGear() {
    if (shouldUpdateGear(true)) {
      currentGear++;
    }
    return this;
  }

  @Override
  public ManualTransmission decreaseGear() {
    if (shouldUpdateGear(false)) {
      currentGear--;
    }
    return this;
  }

  /**
   * Function to determine if the request for speed update(either/increase) should be entertained or
   * not, logic of the system is governed by the rules and specification provided in the problem
   * statement.
   *
   * @param isIncrease Boolean value to determine if the requested update is an increment or
   *     decrement.
   * @return status in boolean format tell the calling method if the speed change can be done.
   */
  private boolean shouldUpdateSpeed(Boolean isIncrease) {
    int speed = isIncrease ? currentSpeed + 1 : currentSpeed - 1;
    boolean isUpdateSpeed = false;
    switch (currentGear) {
      case 1:
        if ((minSpeed <= speed && speed <= h1)) {
          isUpdateSpeed = true;
          currentStatus = TransmissionStatus.OK;
          if (speed >= l2 && isIncrease) {
            currentStatus = TransmissionStatus.MAY_INCREASE_GEAR;
          }
        } else if (speed < minSpeed) {
          currentStatus = TransmissionStatus.MIN_SPEED;
        } else {
          currentStatus = TransmissionStatus.NO_SPEED_INCREASE_INCREASE_GEAR;
        }
        break;
      case 2:
        if (l2 <= speed && speed <= h2) {
          isUpdateSpeed = true;
          currentStatus = TransmissionStatus.OK;
          if (speed <= h1 && !isIncrease) {
            currentStatus = TransmissionStatus.MAY_DECREASE_GEAR;
          } else if (speed >= l3 && isIncrease) {
            currentStatus = TransmissionStatus.MAY_INCREASE_GEAR;
          }
        } else if (speed < l2) {
          currentStatus = TransmissionStatus.NO_SPEED_DECREASE_DECREASE_GEAR;
        } else {
          currentStatus = TransmissionStatus.NO_SPEED_INCREASE_INCREASE_GEAR;
        }
        break;
      case 3:
        if (l3 <= speed && speed <= h3) {
          isUpdateSpeed = true;
          currentStatus = TransmissionStatus.OK;
          if (speed <= h2 && !isIncrease) {
            currentStatus = TransmissionStatus.MAY_DECREASE_GEAR;
          } else if (speed >= l4 && isIncrease) {
            currentStatus = TransmissionStatus.MAY_INCREASE_GEAR;
          }
        } else if (speed < l3) {
          currentStatus = TransmissionStatus.NO_SPEED_DECREASE_DECREASE_GEAR;
        } else {
          currentStatus = TransmissionStatus.NO_SPEED_INCREASE_INCREASE_GEAR;
        }
        break;
      case 4:
        if (l4 <= speed && speed <= h4) {
          isUpdateSpeed = true;
          currentStatus = TransmissionStatus.OK;
          if (speed <= h3 && !isIncrease) {
            currentStatus = TransmissionStatus.MAY_DECREASE_GEAR;
          } else if (speed >= l5 && isIncrease) {
            currentStatus = TransmissionStatus.MAY_INCREASE_GEAR;
          }
        } else if (speed < l4) {
          currentStatus = TransmissionStatus.NO_SPEED_DECREASE_DECREASE_GEAR;
        } else {
          currentStatus = TransmissionStatus.NO_SPEED_INCREASE_INCREASE_GEAR;
        }
        break;
      case 5:
        if (l5 <= speed && speed <= maxSpeed) {
          isUpdateSpeed = true;
          currentStatus = TransmissionStatus.OK;
          if (speed <= h4 && !isIncrease) {
            currentStatus = TransmissionStatus.MAY_DECREASE_GEAR;
          }
        } else if (speed < l5) {
          currentStatus = TransmissionStatus.NO_SPEED_DECREASE_DECREASE_GEAR;
        } else {
          currentStatus = TransmissionStatus.MAX_SPEED;
        }
        break;
      default:
        // Cannot reach here.
        break;
    }
    return isUpdateSpeed;
  }

  /**
   * Function to determine if the request for gear update(either/increase) should be entertained or
   * not, logic of the system is governed by the rules and specification provided in the problem
   * statement.
   *
   * @param isIncrease Boolean value to determine if the requested update is an increment or
   *     decrement.
   * @return status in boolean format tell the calling method if the gear change can be done or not.
   */
  private boolean shouldUpdateGear(Boolean isIncrease) {
    int gear = isIncrease ? currentGear + 1 : currentGear - 1;
    boolean isUpdateGear = false;
    switch (gear) {
      case 0:
        currentStatus = TransmissionStatus.MIN_GEAR;
        break;
      case 1:
        if (currentSpeed <= h1) {
          isUpdateGear = true;
          currentStatus = TransmissionStatus.OK;
        } else {
          currentStatus = TransmissionStatus.NO_DECREASE_GEAR_DECREASE_SPEED;
        }
        break;
      case 2:
        if (currentSpeed >= l2 && currentSpeed <= h2) {
          isUpdateGear = true;
          currentStatus = TransmissionStatus.OK;
        } else if (currentSpeed > h2) {
          currentStatus = TransmissionStatus.NO_DECREASE_GEAR_DECREASE_SPEED;
        } else {
          currentStatus = TransmissionStatus.NO_INCREASE_GEAR_INCREASE_SPEED;
        }
        break;
      case 3:
        if (currentSpeed >= l3 && currentSpeed <= h3) {
          isUpdateGear = true;
          currentStatus = TransmissionStatus.OK;
        } else if (currentSpeed > h3) {
          currentStatus = TransmissionStatus.NO_DECREASE_GEAR_DECREASE_SPEED;
        } else {
          currentStatus = TransmissionStatus.NO_INCREASE_GEAR_INCREASE_SPEED;
        }
        break;
      case 4:
        if (currentSpeed >= l4 && currentSpeed <= h4) {
          isUpdateGear = true;
          currentStatus = TransmissionStatus.OK;
        } else if (currentSpeed > h4) {
          currentStatus = TransmissionStatus.NO_DECREASE_GEAR_DECREASE_SPEED;
        } else {
          currentStatus = TransmissionStatus.NO_INCREASE_GEAR_INCREASE_SPEED;
        }
        break;
      case 5:
        if (currentSpeed >= l5) {
          isUpdateGear = true;
          currentStatus = TransmissionStatus.OK;
        } else {
          currentStatus = TransmissionStatus.NO_INCREASE_GEAR_INCREASE_SPEED;
        }
        break;
      case 6:
        currentStatus = TransmissionStatus.MAX_GEAR;
        break;
      default:
        // Cannot reach here
        break;
    }
    return isUpdateGear;
  }
}
