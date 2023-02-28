/**
 * Author: Jack, https://github.com/jack-milligan
 * Simple auto-clicker that repeatedly clicks the left mouse button at a random interval.
 * Includes a method to end the program if the mouse is moved from its original position.
 */

import java.awt.*;
import java.awt.event.InputEvent;

public class Clicking {
    /**
     * Initializes the auto-clicker and starts the clicking loop.
     * @throws AWTException if the platform configuration does not allow low-level input control.
     */
    public Clicking() throws AWTException {
        Robot robot = new Robot();
        // Delay before starting to allow time to position the mouse
        robot.delay(5000);
        int i = 0;

        while (true) {
            Point autoClickPointLocation = MouseInfo.getPointerInfo().getLocation();

            // Perform a full click (press and release) with random delay between clicks
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.delay(randomNumber(0, 5));
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.delay(randomNumber(0, 5));
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.delay(randomNumber(0, 5));
            robot.mouseRelease(InputEvent.BUTTON1_MASK);

            // Add a random delay after the full click
            robot.delay(900 + randomNumber(0, 150));
            exitProgramIfMouseMoved(autoClickPointLocation);
            i++;
        }
    }
    /**
     * Generates a random integer between the given minimum and maximum values, inclusive.
     * @param min the minimum value of the random integer
     * @param max the maximum value of the random integer
     * @return a random integer between min and max
     */
    private static int randomNumber(int min, int max) {
        return (int) (min + (Math.random() * (max - min)));
    }
    /**
     * Ends the program if the mouse has moved from its original position.
     * @param autoClickPointLocation the original location of the mouse when the auto-clicker started
     */
    private static void exitProgramIfMouseMoved(Point autoClickPointLocation) {
        Point currentMouseLocation = MouseInfo.getPointerInfo().getLocation();
        if (!currentMouseLocation.equals(autoClickPointLocation)) {
            System.exit(0);
        }
    }
}



