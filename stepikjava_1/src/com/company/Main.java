package com.company;
import static java.lang.System.*;
public class Main {

    public static void main(String[] args) {
        Robot r1 = new Robot(0, 0, Direction.UP);

    }
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int x_new=toX-robot.getX();
        int y_new=toY-robot.getY();
        Direction dir = robot.getDirection();
        if(x_new>0)
        {
            while(dir!=Direction.RIGHT)
            {robot.turnLeft();
            }
            for(int i =0;i<x_new;i++)
            {
                robot.stepForward();
            }

        }
        if(x_new<0)
        {
            while(dir!=Direction.LEFT)
            { robot.turnLeft();
            }
            for(int i =0;i<Math.abs(x_new);i++)
            {
                robot.stepForward();
            }

        }
        if(y_new>0)
        {
            while(dir!=Direction.UP)
            {robot.turnLeft();
            }
            for(int i =0;i<y_new;i++)
            {
                robot.stepForward();
            }

        }
        if(y_new<0)
        {
            while(dir!=Direction.DOWN)
            {robot.turnLeft();
            }
            for(int i =0;i<Math.abs(y_new);i++)
            {
                robot.stepForward();
            }

        }
    }
}


