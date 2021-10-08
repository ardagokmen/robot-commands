package org.arda.robotcommands.controller.resource;

import lombok.Builder;
import lombok.Getter;
import org.arda.robotcommands.enums.Direction;

@Builder
@Getter
public class RobotResource {
    private final int positionX;
    private final int positionY;
    private final Direction direction;
}
