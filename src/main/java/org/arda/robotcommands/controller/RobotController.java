package org.arda.robotcommands.controller;

import lombok.RequiredArgsConstructor;
import org.arda.robotcommands.controller.resource.RobotResource;
import org.arda.robotcommands.service.RobotService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/robot", consumes = MediaType.TEXT_PLAIN_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class RobotController {

    private final RobotService robotService;

    @PostMapping
    public ResponseEntity<RobotResource> executeScript(@RequestBody String script){
        return ResponseEntity.ok(robotService.executeScript(script));
    }
}
