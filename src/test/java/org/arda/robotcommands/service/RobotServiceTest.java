package org.arda.robotcommands.service;

import org.arda.robotcommands.controller.resource.RobotResource;
import org.arda.robotcommands.enums.Direction;
import org.arda.robotcommands.exceptions.InvalidCommandException;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RobotServiceTest {

    private RobotService underTest;

    @BeforeMethod
    public void setUp() {
        underTest = new RobotService();
    }

    @Test
    public void executeScriptShouldReturnValidRobotResource(){
        // Given
        String dummyScript = "FORWARD 3\nRIGHT";

        // When
        RobotResource result = underTest.executeScript(dummyScript);

        //Then
        Assert.assertEquals(result.getDirection(), Direction.SOUTH);
        Assert.assertEquals(result.getPositionX(), 3);
        Assert.assertEquals(result.getPositionY(), 0);
    }

    @Test(expectedExceptions = InvalidCommandException.class)
    public void throwsInvalidCommandExceptionWhenCommandIsInvalid(){
        // Given
        String dummyScript = "FORWARD 3 5";

        // When
        underTest.executeScript(dummyScript);
    }

}
