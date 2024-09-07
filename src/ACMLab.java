import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;

public class ACMLab extends GraphicsProgram {
	private static final int SHAPE_H = 100;
	private static final int SHAPE_W = 200;
	private static final int START_Y = 300;
	private static final int START_X = 300;
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}
	
	public void run() {
		GLabel label = new GLabel("Hello World", START_X, START_Y);
		label.setColor(Color.red);
		label.setFont("SF-Pro-24");
		add(label);
		
		GRect rect = new GRect(START_X, START_Y, SHAPE_W, SHAPE_H);
		add(rect);
		rect.move(2, 1);
		pause(5);
		
		GOval oval = new GOval(START_X, START_Y, SHAPE_W, SHAPE_H);
		add(oval);
		
		GLine line = new GLine(START_X, START_Y, SHAPE_W, SHAPE_H);
		add(line);
		
		GImage image = new GImage("media/robot.png", START_X, START_Y);
		image.setSize(400, 400);
		add(image);
	}
	
	public static void main(String[] args) {
		new ACMLab().start();
	}
}
