package com.behsa.apigw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.*;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ControllerRestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ControllerRestResponseExceptionHandler.class);

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Object> handleNumberFormatException(NumberFormatException ex) {
        logger.info("number format is wrong", ex);
        return new ResponseEntity<>("error at clock:" + new Date().getTime(), new HttpHeaders(), BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.info("illegul arg", ex);
        return new ResponseEntity<>("error at clock:" + new Date().getTime(), new HttpHeaders(), BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> entitynotfoundexception(EntityNotFoundException ex) {
        logger.info("entity not found", ex);
        return new ResponseEntity<>("error at clock:" + new Date().getTime(), new HttpHeaders(), BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> sqlException(SQLException ex) {
        logger.info("sql ! ", ex);
        return new ResponseEntity<>("error at clock:" + new Date().getTime(), new HttpHeaders(), BAD_REQUEST);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> throwable(Throwable ex) {
        logger.info(ex.getMessage());
        return new ResponseEntity<>("error at clock:" + new Date().getTime(), new HttpHeaders(), BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception ex) {
        logger.info(ex.getMessage());
        return new ResponseEntity<>("error at clock:" + new Date().getTime(), new HttpHeaders(), BAD_REQUEST);
    }


}
