package org.arda.robotcommands.enums;


public enum Direction {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    private final int index;

    Direction(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static Direction getDirectionByIndex(int index){
        for(Direction direction: values()){
            if(direction.getIndex() == index){
                return direction;
            }
        }
        throw new RuntimeException("Unknown direction index.");
    }

}
