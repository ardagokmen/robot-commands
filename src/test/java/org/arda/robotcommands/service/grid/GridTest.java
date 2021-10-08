package org.arda.robotcommands.service.grid;

import org.arda.robotcommands.constants.Constants;
import org.arda.robotcommands.enums.Direction;
import org.arda.robotcommands.exceptions.InvalidCommandException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class GridTest {


    private Grid underTest;

    @BeforeMethod
    public void setUp() {
        underTest = new Grid(Constants.GRID_HEIGHT, Constants.GRID_WIDTH);
    }

    @Test(expectedExceptions = InvalidCommandException.class)
    public void shouldThrowInvalidCommandExceptionWhenStepsSmallerThanOne(){
        int invalidSteps = 0;
        underTest.moveRobot(invalidSteps);
    }

    @Test
    public void turningRightFourTimesShouldEndAtSameDirection(){
        Random ran = new Random();
        int random = ran.nextInt(4);
        Direction randomDirection = Direction.getDirectionByIndex(random);

        underTest.setPosition(0,0, randomDirection);
        for (int i = 0; i<4; i++){
            underTest.turnRobotRight();
        }

        Assert.assertEquals(randomDirection, underTest.getRobot().getDirection());
    }

    @Test
    public void turningAroundTwoTimesShouldEndAtSameDirection(){
        Random ran = new Random();
        int random = ran.nextInt(2);
        Direction randomDirection = Direction.getDirectionByIndex(random);
        underTest.setPosition(0,0, randomDirection);
        for (int i = 0; i<2; i++){
            underTest.turnRobotAround();
        }

        Assert.assertEquals(randomDirection, underTest.getRobot().getDirection());

    }

}
