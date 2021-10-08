package org.arda.robotcommands.service.grid;

import org.arda.robotcommands.enums.Direction;
import org.arda.robotcommands.exceptions.InvalidCommandException;
import org.arda.robotcommands.exceptions.OutOfBoundsException;

public class Grid {

    private final int height;
    private final int width;
    private final Robot robot;

    public Grid(int height, int width){
        this.height = height - 1;
        this.width = width - 1;
        this.robot = new Robot();
    }

    public void setPosition(int x, int y, Direction direction){
        if(isInBounds(x, y)){
            getRobot().setX(x);
            getRobot().setY(y);
            getRobot().setDirection(direction);
        }
    }

    public void moveRobot(int steps){
        if(steps <= 0){
            throw new InvalidCommandException("Steps must be greater than 0.");
        }

        Direction direction = getRobot().getDirection();
        switch (direction){
            case NORTH:
                setPosition(getRobot().getX(), getRobot().getY() - steps, Direction.NORTH);
                break;
            case EAST:
                setPosition(getRobot().getX() + steps, getRobot().getY(), Direction.EAST);
                break;
            case SOUTH:
                setPosition(getRobot().getX(), getRobot().getY() + steps, Direction.SOUTH);
                break;
            case WEST:
                setPosition(getRobot().getX() - steps, getRobot().getY(), Direction.WEST);
                break;
        }
    }

    public void turnRobotRight(){
        getRobot().turnRight();
    }

    public void turnRobotAround(){
        getRobot().turnAround();
    }

    public Robot getRobot(){
        return this.robot;
    }

    private boolean isInBounds(int x, int y){
        if(0 <= x && x <= height && 0<= width && y <= width){
            return true;
        }

        throw new OutOfBoundsException("Robot is out of bounds.");
    }




}
