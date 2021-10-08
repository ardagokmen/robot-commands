package org.arda.robotcommands.service;

import lombok.RequiredArgsConstructor;
import org.arda.robotcommands.constants.Constants;
import org.arda.robotcommands.controller.resource.RobotResource;
import org.arda.robotcommands.enums.Command;
import org.arda.robotcommands.enums.Direction;
import org.arda.robotcommands.exceptions.InvalidCommandException;
import org.arda.robotcommands.service.grid.Grid;
import org.arda.robotcommands.service.grid.Robot;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RobotService {

    private static final Grid grid = new Grid(Constants.GRID_HEIGHT,Constants.GRID_WIDTH);

    public RobotResource executeScript(String script){

        List<String> commandList = Arrays.asList(script.split("\n"));
        commandList.forEach(RobotService::executeCommand);
        Robot haltedRobot = grid.getRobot();

        return RobotResource.builder()
                .positionX(haltedRobot.getX())
                .positionY(haltedRobot.getY())
                .direction(haltedRobot.getDirection())
                .build();
    }

    private static void executeCommand(String command){
        command = command.replaceAll("(\\r|\\n)", "");
        List<String> commandBody = Arrays.asList(command.split(" "));
        if(commandBody.isEmpty()){
            throw new InvalidCommandException(Constants.INVALID_COMMAND);
        }
        Command commandType = Command.valueOf(commandBody.get(0));

        switch (commandType){
            case POSITION:
                if(commandBody.size() != 4) throw new InvalidCommandException(Constants.INVALID_COMMAND);
                grid.setPosition(Integer.parseInt(commandBody.get(1)),
                        Integer.parseInt(commandBody.get(2)),
                        Direction.valueOf(commandBody.get(3)));
                break;

            case FORWARD:
                if(commandBody.size() != 2) throw new InvalidCommandException(Constants.INVALID_COMMAND);
                grid.moveRobot(Integer.parseInt(commandBody.get(1)));
                break;

            case WAIT:
                if(commandBody.size() != 1) throw new InvalidCommandException(Constants.INVALID_COMMAND);
                break;

            case TURNAROUND:
                if(commandBody.size() != 1) throw new InvalidCommandException(Constants.INVALID_COMMAND);
                grid.turnRobotAround();
                break;

            case RIGHT:
                if(commandBody.size() != 1) throw new InvalidCommandException(Constants.INVALID_COMMAND);
                grid.turnRobotRight();
                break;

            default:
                throw new InvalidCommandException(Constants.INVALID_COMMAND);
        }
    }

}
