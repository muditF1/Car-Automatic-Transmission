import org.junit.Test;

import vehicle.ManualTransmission;
import vehicle.RegularManualTransmission;

import static org.junit.Assert.assertEquals;

/** This is a test class for testing the RegularManualTransmission implementation. */
public class RegularManualTransmissionTest {
@Test
  public void test(){

}
  //
//  // Check if the minimum speed cannot be lower than 1, throw exception in that case.
//  @Test(expected = IllegalArgumentException.class)
//  public void testMinimumSpeedLowerThanBeZero() {
//    ManualTransmission obj = new RegularManualTransmission(-1, -2, -3, -4, -4, -6, -6, -8, -8, -10);
//  }
//
//  // Check if the minimum speed is greater than zero then throw exception.
//  @Test(expected = IllegalArgumentException.class)
//  public void testMinimumSpeedGreaterThanZero() {
//    ManualTransmission obj = new RegularManualTransmission(4, 10, 9, 14, 10, 16, 12, 18, 17, 19);
//  }
//
//  // Check if none of the speeds can be given a negative value.
//  @Test(expected = IllegalArgumentException.class)
//  public void testNegativeSpeedInputs() {
//    ManualTransmission obj = new RegularManualTransmission(0, -2, -2, -4, -4, -6, -6, -8, -8, -10);
//  }
//
//  // Check if Higher gear speed is less than lower gear speed, throw an exception.
//  @Test(expected = IllegalArgumentException.class)
//  public void testHigherGearSpeedNotLessThanLowerGearSpeed() {
//    ManualTransmission obj = new RegularManualTransmission(0, 2, 3, 1, 4, 6, 6, 8, 8, 10);
//  }
//
//  // Check that the transition of speed for adjacent gears should not be non-overlapping.
//  @Test(expected = IllegalArgumentException.class)
//  public void testNonOverlappingSpeedRanges() {
//    ManualTransmission obj = new RegularManualTransmission(0, 2, 3, 4, 4, 6, 6, 8, 8, 10);
//  }
//
//  // Check if higher gear speed for adjacent gears is not always greater for the higher gear.
//  @Test(expected = IllegalArgumentException.class)
//  public void testLowerGearSpeedAgainstHigerGearSpeed() {
//    ManualTransmission obj = new RegularManualTransmission(0, 2, 2, 10, 1, 6, 6, 8, 8, 10);
//  }
//
//  // Test equal values of speed for lower and higher range of a gear and throw exception as this is
//  // not supported.
//  @Test(expected = IllegalArgumentException.class)
//  public void testEqualValuesForLAndHGearSpeed() {
//    ManualTransmission obj = new RegularManualTransmission(0, 3, 2, 6, 6, 6, 9, 12, 11, 15);
//  }
//
//  // Test Lower speed range for a higher gear and throw exception as it is not supported.
//  @Test(expected = IllegalArgumentException.class)
//  public void testLowerSpeedRangeForAHigherGear() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 2, 9, 5, 6, 9, 12, 11, 15);
//  }
//
//  // Test the initialisation of speed.
//  @Test
//  public void testStartingSpeed() {
//    ManualTransmission obj = new RegularManualTransmission(0, 2, 2, 4, 4, 6, 6, 8, 8, 10);
//    assertEquals(0, obj.getSpeed());
//  }
//
//  // Test the initialisation of the gear.
//  @Test
//  public void testStartingGear() {
//    ManualTransmission obj = new RegularManualTransmission(0, 2, 2, 4, 4, 6, 6, 8, 8, 10);
//    assertEquals(1, obj.getGear());
//  }
//
//  // Test the initialisation of the current status.
//  @Test
//  public void testStartingStatus() {
//    ManualTransmission obj = new RegularManualTransmission(0, 2, 2, 4, 4, 6, 6, 8, 8, 10);
//    assertEquals("OK: everything is OK.", obj.getStatus());
//  }
//
//  // Smoke test for speed increase.
//  @Test
//  public void testIncreaseSpeed() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//
//    obj.increaseSpeed();
//    assertEquals(1, obj.getSpeed());
//  }
//
//  // Smoke test for gear increase.
//  @Test
//  public void testIncreaseGear() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//
//    // increasing the speed to 3.
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//
//    obj.increaseGear();
//    assertEquals(2, obj.getGear());
//  }
//
//  // Smoke test for speed decrease.
//  @Test
//  public void testDecreaseSpeed() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//
//    // increasing the speed to 3.
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//
//    obj.decreaseSpeed();
//    assertEquals(3, obj.getSpeed());
//  }
//
//  // Smoke test for gear decrease.
//  @Test
//  public void testDecreaseGear() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//
//    // increasing the speed to 3 and changing gear to 2.
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseGear();
//
//    obj.decreaseGear();
//    assertEquals(1, obj.getGear());
//  }
//
//  // Test status OK for increasing speed.
//  @Test
//  public void testStatusOKWithSpeedIncrease() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    assertEquals("OK: everything is OK.", obj.getStatus());
//  }
//
//  // Test status OK for decreasing speed.
//  @Test
//  public void testStatusOKWithSpeedDecrease() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.decreaseSpeed();
//    assertEquals("OK: everything is OK.", obj.getStatus());
//  }
//
//  // Test status after increasing speed from one gear to other and then again increasing speed.
//  @Test
//  public void testStatusOKWithSpeedIncreaseAtSameGear() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseGear();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    assertEquals("OK: everything is OK.", obj.getStatus());
//  }
//
//  // Test Status immediately after increasing gear
//  @Test
//  public void testStatusOKWithGearIncrease() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseGear();
//
//    assertEquals("OK: everything is OK.", obj.getStatus());
//  }
//
//  // Test status immediately after decreasing the gear.
//  @Test
//  public void testStatusOKWithGearDecrease() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseGear();
//    obj.decreaseGear();
//
//    assertEquals("OK: everything is OK.", obj.getStatus());
//  }
//
//  // Test status for if we can increase the gear
//  @Test
//  public void testStatusMayIncreaseGear() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    assertEquals("OK: you may increase the gear.", obj.getStatus());
//  }
//
//  // Test status for if we can decrease the gear
//  @Test
//  public void testStatusMayDecreaseGear() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseGear();
//    obj.increaseSpeed();
//    obj.decreaseSpeed();
//    assertEquals("OK: you may decrease the gear.", obj.getStatus());
//  }
//
//  // Test status when speed in current gear cannot be increased.
//  @Test
//  public void testStatusWhenSpeedCannotBeIncreased() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    assertEquals("Cannot increase speed, increase gear first.", obj.getStatus());
//  }
//
//  // Test status when speed in the current gear cannot be decreased.
//  @Test
//  public void testStatusWhenSpeedCannotBeDecreased() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseGear();
//    obj.decreaseSpeed();
//    obj.decreaseSpeed();
//    assertEquals("Cannot decrease speed, decrease gear first.", obj.getStatus());
//  }
//
//  // Test status when the gear cannot be increased without increasing speed first.
//  @Test
//  public void testStatusWhenGearCannotBeIncreased() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseGear();
//    assertEquals("Cannot increase gear, increase speed first.", obj.getStatus());
//  }
//
//  // Test status when the gear cannot be decreased without decreasing speed first.
//  @Test
//  public void testStatusWhenGearCannotBeDecreased() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseGear();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.decreaseGear();
//    assertEquals("Cannot decrease gear, decrease speed first.", obj.getStatus());
//  }
//
//  // Test reaching the maximum speed and then check status after reaching maximum speed also
//  // trying to increase it further than maximum speed.
//  @Test
//  public void testStatusMaxSpeed() {
//    ManualTransmission obj = new RegularManualTransmission(0, 2, 2, 4, 4, 6, 6, 8, 8, 10);
//
//    for (int i = 0; i < 4; i++) {
//      obj.increaseSpeed();
//      obj.increaseSpeed();
//      obj.increaseGear();
//    }
//
//    for (int i = 0; i < 3; i++) {
//      obj.increaseSpeed();
//    }
//
//    assertEquals("Cannot increase speed. Reached maximum speed.", obj.getStatus());
//  }
//
//  // Test decreasing the speed when we are already at the minimum speed.
//  @Test
//  public void testStatusMinSpeed() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//    obj.decreaseSpeed();
//
//    assertEquals("Cannot decrease speed. Reached minimum speed.", obj.getStatus());
//  }
//
//  // Test reaching the maximum gear and trying to increase it further.
//  @Test
//  public void testStatusMaxGear() {
//    ManualTransmission obj = new RegularManualTransmission(0, 2, 2, 4, 4, 6, 6, 8, 8, 10);
//
//    for (int i = 0; i < 4; i++) {
//      obj.increaseSpeed();
//      obj.increaseSpeed();
//      obj.increaseGear();
//    }
//
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//
//    obj.increaseGear();
//    obj.increaseGear();
//
//    assertEquals("Cannot increase gear. Reached maximum gear.", obj.getStatus());
//  }
//
//  // Test the status on the minimum gear.
//  @Test
//  public void testStatusMinGear() {
//    ManualTransmission obj = new RegularManualTransmission(0, 2, 2, 4, 4, 6, 6, 8, 8, 10);
//    obj.decreaseGear();
//
//    assertEquals("Cannot decrease gear. Reached minimum gear.", obj.getStatus());
//  }
//
//  // Test increasing speed and gear from minimum to maximum.
//  @Test
//  public void testTransmissionIncreaseSpeedAndGearMinToMax() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//
//    obj.increaseGear();
//    assertEquals(2, obj.getGear());
//
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//
//    obj.increaseGear();
//    assertEquals(3, obj.getGear());
//
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//
//    obj.increaseGear();
//    assertEquals(4, obj.getGear());
//
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//
//    obj.increaseGear();
//    assertEquals(5, obj.getGear());
//
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    assertEquals(13, obj.getSpeed());
//    assertEquals(5, obj.getGear());
//    obj.increaseSpeed();
//    assertEquals("Cannot increase speed. Reached maximum speed.", obj.getStatus());
//    obj.increaseGear();
//    assertEquals("Cannot increase gear. Reached maximum gear.", obj.getStatus());
//  }
//
//  // Test decreasing speed and gear from minimum to maximum.
//  @Test
//  public void testTransmissionIncreaseSpeedAndGearMaxToMin() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 3, 6, 6, 9, 7, 11, 10, 13);
//
//    testTransmissionIncreaseSpeedAndGearMinToMax();
//
//    for (int i = 0; i < 2; i++) {
//      obj.decreaseSpeed();
//      obj.decreaseSpeed();
//      obj.decreaseSpeed();
//      obj.decreaseGear();
//    }
//
//    obj.decreaseSpeed();
//    obj.decreaseGear();
//
//    for (int i = 0; i < 3; i++) {
//      obj.decreaseSpeed();
//    }
//
//    obj.decreaseGear();
//
//    for (int i = 0; i < 3; i++) {
//      obj.decreaseSpeed();
//    }
//    assertEquals(0, obj.getSpeed());
//    assertEquals(1, obj.getGear());
//    obj.decreaseSpeed();
//    assertEquals("Cannot decrease speed. Reached minimum speed.", obj.getStatus());
//    obj.decreaseGear();
//    assertEquals("Cannot decrease gear. Reached minimum gear.", obj.getStatus());
//  }
//
//  // A random driving workflow test to over all test the transmission.
//  @Test
//  public void testRandomDrivingWorkflow() {
//    ManualTransmission obj = new RegularManualTransmission(0, 4, 2, 8, 7, 9, 9, 12, 11, 15);
//    for (int i = 0; i < 3; i++) {
//      obj.increaseSpeed();
//    }
//    assertEquals(obj.getStatus(), "OK: you may increase the gear.");
//
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//    assertEquals(obj.getStatus(), "Cannot increase speed, increase gear first.");
//
//    obj.decreaseSpeed();
//    obj.increaseGear();
//    assertEquals(obj.getSpeed(), 3);
//    assertEquals(obj.getGear(), 2);
//    obj.increaseGear();
//    assertEquals(obj.getStatus(), "Cannot increase gear, increase speed first.");
//    obj.increaseSpeed();
//    obj.increaseSpeed();
//
//    obj.increaseSpeed();
//    assertEquals(obj.getStatus(), "OK: everything is OK.");
//    obj.increaseSpeed();
//    assertEquals(obj.getStatus(), "OK: you may increase the gear.");
//    obj.increaseGear();
//    assertEquals(obj.getStatus(), "OK: everything is OK.");
//  }
}
