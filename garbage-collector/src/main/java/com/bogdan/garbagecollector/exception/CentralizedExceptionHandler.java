package com.bogdan.garbagecollector.exception;

import com.bogdan.garbagecollector.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class CentralizedExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CentralizedExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus( value = HttpStatus.BAD_REQUEST)
    public MessageDTO illegalArgumentException( final IllegalArgumentException e) {
        return new MessageDTO(e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus( value = HttpStatus.NOT_FOUND)
    public MessageDTO notFoundException(final NotFoundException e) {
        return new MessageDTO(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public MessageDTO internalServerError(final Exception e) {
        LOGGER.warn(e.getMessage(), e);
        return new MessageDTO(e.getMessage());
    }
}
