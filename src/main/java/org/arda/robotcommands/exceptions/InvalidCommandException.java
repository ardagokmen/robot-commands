package org.arda.robotcommands.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCommandException extends RuntimeException{

    public InvalidCommandException(String message) {
        super(message);
    }
}
