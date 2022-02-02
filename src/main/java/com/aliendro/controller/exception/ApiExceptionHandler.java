package com.aliendro.controller.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    Logger logger = LogManager.getLogger(ApiExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(ApiRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiExceptionMessage handleApiRequestException(ApiRequestException ex) {
        logger.error(ex);
        return new ApiExceptionMessage(ex.getMessage());
    }
}
