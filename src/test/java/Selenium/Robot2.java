package Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Robot2 {
  public static void main(String[] args) throws AWTException {
	Robot robot = new Robot();
	robot.delay(2000);
	
	String text = "idea64";
	
	StringSelection selction = new StringSelection(text);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selction, null);
	
	robot.keyPress(KeyEvent.VK_WINDOWS);
	robot.keyPress(KeyEvent.VK_R);
	robot.keyRelease(KeyEvent.VK_R);
	robot.keyRelease(KeyEvent.VK_WINDOWS);
	
	robot.delay(500);
	
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	
	robot.keyRelease(KeyEvent.VK_CONTROL);
	
	
	robot.delay(1000);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	
	robot.delay(10000);
	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	
    robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
	robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

	robot.delay(5000);
	
	robot.keyPress(KeyEvent.VK_ALT);
	robot.keyPress(KeyEvent.VK_F4);
	robot.keyRelease(KeyEvent.VK_F4);
	robot.keyRelease(KeyEvent.VK_ALT);
	
	robot.delay(5000);
	
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);



//	robot.delay(500);
//    robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

	

}
}
