import java.awt.*;
import java.awt.event.InputEvent;

public class Clicking {
    public Clicking() throws AWTException {
        Robot robot = new Robot();
        robot.delay(5000);
        int i = 0;

        while (true) {
            Point autoClickPointLocation = MouseInfo.getPointerInfo().getLocation();
            //Left Key Press
            robot.mousePress(InputEvent.BUTTON1_MASK);
            //Random Delay
            robot.delay(randomNumber(0, 5));
            //Left Key Release
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            //Random
            robot.delay(randomNumber(0, 5));
            //Left Key Press
            robot.mousePress(InputEvent.BUTTON1_MASK);
            //Random Delay
            robot.delay(randomNumber(0, 5));
            //Left Key Release
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            // Random Delay after full click
            robot.delay(900 + randomNumber(0, 150));
            exitProgramIfMouseMoved(autoClickPointLocation);
            i++;
        }
    }
    private static int randomNumber(int min, int max) {
        //obtain a number;
        return (int) (min + (Math.random() * (max - min)));
    }
    // method to end program is the mouse is moved
    private static void exitProgramIfMouseMoved(Point autoClickPointLocation) {
        Point currentMouseLocation = MouseInfo.getPointerInfo().getLocation();
        if (!currentMouseLocation.equals(autoClickPointLocation)) {
            System.exit(0);
        }
    }
}



