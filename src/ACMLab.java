import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;

public class ACMLab extends GraphicsProgram {
	//Program Dimensions
    public static final int PROGRAM_HEIGHT = 600;
    public static final int PROGRAM_WIDTH = 800;

    //PAWL-E Robot Dimensions
    public static final int ROBOT_WIDTH = 300;
    public static final int ROBOT_HEIGHT = 350;

    //PAWL-E Robot Head Dimensions
    public static final int HEAD_WIDTH = 190;
    public static final int HEAD_HEIGHT = 125;
    public static final double HEAD_X_OFFSET = 50;
    public static final double HEAD_Y_OFFSET = -125;

    //PAWL-E Robot Body Dimensions
    public static final int BODY_WIDTH = 300;
    public static final int BODY_HEIGHT = 200;
    public static final double BODY_CORNER_RADIUS = 20;

    //PAWL-E Robot Top Dimensions
    public static final int TOP_WIDTH = 300;
    public static final int TOP_HEIGHT = 100;

    //PAWL-E Robot Arm Dimensions
    public static final int ARM_WIDTH = 30;
    public static final int ARM_HEIGHT = 125;
    public static final double LEFT_ARM_X = 25;
    public static final double LEFT_ARM_Y = 175;
    public static final double RIGHT_ARM_X = 300;
    public static final double RIGHT_ARM_Y = 195;
    public static final double LEFT_ARM_ROTATION = -145;
    public static final double RIGHT_ARM_ROTATION = 145;

    //PAWL-E Robot Leg Dimensions
    public static final int LEG_SIZE = 50;
    public static final int INNER_LEG_SIZE = 30;
    public static final double LEG_Y = 300;
    public static final double LEFT_LEG_X = 0;
    public static final double RIGHT_LEG_X = 250; // 300 - 50
    public static final double INNER_LEG_OFFSET = 10;
    public static final double INNER_LEG_Y = 310;

    //PAWL-E Robot Hand Dimensions
    public static final int HAND_SIZE = 40;
    public static final double LEFT_HAND_X = -95;
    public static final double LEFT_HAND_Y = 45;
    public static final double RIGHT_HAND_X = 350; // 300 + 50
    public static final double RIGHT_HAND_Y = 45;

    //PAWL-E Robot Label Dimensions
    public static final double ROBOT_NAME_X = 100;
    public static final double ROBOT_NAME_Y = 145;
    public static final double AUTHOR_NAME_X = 25;
    public static final double AUTHOR_NAME_Y = 175;

    //PAWL-E Robot Mascot Dimensions
    public static final int MASCOT_WIDTH = 100;
    public static final int MASCOT_HEIGHT = 75;
    public static final double MASCOT_X = 100;
    public static final double MASCOT_Y = 195;

    //PAWL-E Robot Colors
    public static final Color PACIFIC_ORANGE = new Color(255, 103, 29);
    public static final Color PACIFIC_DARK_ORANGE = new Color(230, 83, 0);
    public static final Color PACIFIC_YELLOW = new Color(244, 178, 35);

    public void init() {
        setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
        requestFocus();
    }

    public void run() {
        //Center Coordinates
        double centerX = (getWidth() - ROBOT_WIDTH) / 2;
        double centerY = (getHeight() - ROBOT_HEIGHT) / 2;

        //Create Robot Structure Compound
        GCompound robotStructure = new GCompound();

        //Add Robot Head
        GImage robotHead = new GImage("media/robot.png");
        robotHead.setSize(HEAD_WIDTH, HEAD_HEIGHT);
        robotStructure.add(robotHead, HEAD_X_OFFSET, HEAD_Y_OFFSET);

        //Add Robot Top
        robotStructure.add(getRect(0, 0, TOP_WIDTH, TOP_HEIGHT, BODY_CORNER_RADIUS, 0, Color.BLACK));

        //Add Robot Arms
        robotStructure.add(getRect(LEFT_ARM_X, LEFT_ARM_Y, ARM_WIDTH, ARM_HEIGHT, BODY_CORNER_RADIUS, LEFT_ARM_ROTATION, PACIFIC_DARK_ORANGE));
        robotStructure.add(getRect(RIGHT_ARM_X, RIGHT_ARM_Y, ARM_WIDTH, ARM_HEIGHT, BODY_CORNER_RADIUS, RIGHT_ARM_ROTATION, PACIFIC_DARK_ORANGE));

        //Add Robot Body
        robotStructure.add(getRect(0, 100, BODY_WIDTH, BODY_HEIGHT, BODY_CORNER_RADIUS, 0, PACIFIC_ORANGE));

        //Add Robot Legs
        robotStructure.add(getOval(LEG_SIZE, LEG_SIZE, LEFT_LEG_X, LEG_Y, Color.BLACK), LEFT_LEG_X, LEG_Y);
        robotStructure.add(getOval(LEG_SIZE, LEG_SIZE, RIGHT_LEG_X, LEG_Y, Color.BLACK), RIGHT_LEG_X, LEG_Y);
        
        robotStructure.add(getOval(INNER_LEG_SIZE, INNER_LEG_SIZE, RIGHT_LEG_X + INNER_LEG_OFFSET, INNER_LEG_Y, PACIFIC_YELLOW),
        						   RIGHT_LEG_X + INNER_LEG_OFFSET, INNER_LEG_Y);
        robotStructure.add(getOval(INNER_LEG_SIZE, INNER_LEG_SIZE, LEFT_LEG_X + INNER_LEG_OFFSET, INNER_LEG_Y, 
				   				   PACIFIC_YELLOW), LEFT_LEG_X + INNER_LEG_OFFSET, INNER_LEG_Y);

        //Add Robot Hands
        robotStructure.add(getOval(HAND_SIZE, HAND_SIZE, LEFT_HAND_X, LEFT_HAND_Y, PACIFIC_YELLOW), LEFT_HAND_X, LEFT_HAND_Y);
        robotStructure.add(getOval(HAND_SIZE, HAND_SIZE, RIGHT_HAND_X, RIGHT_HAND_Y, PACIFIC_YELLOW), RIGHT_HAND_X, RIGHT_HAND_Y);

        //Add Robot Name to PAWL-E Robot
        GLabel robotName = new GLabel("PAWL-E");
        robotName.setFont("SF-Pro-25");
        robotStructure.add(robotName, ROBOT_NAME_X, ROBOT_NAME_Y);

        //Add Author Name to PAWL-E Robot
        GLabel authorName = new GLabel("Sarah Akhtar's Robot");
        authorName.setFont("SF-Pro-25");
        robotStructure.add(authorName, AUTHOR_NAME_X, AUTHOR_NAME_Y);

        //Add Mascot to PAWL-E Robot
        GImage tigerMascot = new GImage("media/pacific.png");
        tigerMascot.setSize(MASCOT_WIDTH, MASCOT_HEIGHT);
        robotStructure.add(tigerMascot, MASCOT_X, MASCOT_Y);

        //Add PAWL-E Robot
        add(robotStructure, centerX, centerY + HAND_SIZE);
    }

    //Creates rectangle with specified information
    public GRoundRect getRect(double x, double y, int w, int h, double radius, double rotation, Color color) {
        GRoundRect rectangle = new GRoundRect(x, y, w, h, radius, radius);
        rectangle.setFilled(true);
        rectangle.setColor(color);
        rectangle.rotate(rotation);
        return rectangle;
    }

    //Creates oval with specified information
    public GOval getOval(int width, int height, double x, double y, Color color) {
        GOval oval = new GOval(width, height);
        oval.setFilled(true);
        oval.setColor(color);
        oval.setFillColor(color);
        return oval;
    }

    public static void main(String[] args) {
        new ACMLab().start();
    }
}
