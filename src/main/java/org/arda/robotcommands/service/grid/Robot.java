package org.arda.robotcommands.service.grid;

import org.arda.robotcommands.enums.Direction;

public class Robot {

    private int x;
    private int y;
    private Direction direction;

    public Robot(){
        this.x = 0;
        this.y = 0;
        this.direction = Direction.EAST;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    void turnRight(){
        this.direction = Direction.getDirectionByIndex((getDirection().getIndex() + 1) % 4);
    }

    void turnAround(){
        this.direction = Direction.getDirectionByIndex((getDirection().getIndex() + 2) % 4);
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    void setDirection(Direction direction) {
        this.direction = direction;
    }
}
