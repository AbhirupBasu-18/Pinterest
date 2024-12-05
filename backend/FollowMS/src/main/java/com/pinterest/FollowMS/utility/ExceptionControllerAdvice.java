package com.pinterest.FollowMS.utility;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pinterest.FollowMS.exception.FollowException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
//            @Autowired
//            Environment environment;
            @ExceptionHandler(Exception.class)
            public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
                        ErrorInfo error = new ErrorInfo();
             error.setErrorMessage("General.EXCEPTION_MESSAGE");
                        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                        error.setTimestamp(LocalDateTime.now());
                        return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            @ExceptionHandler(FollowException.class)
            public ResponseEntity<ErrorInfo> infyBankexceptionHandler(FollowException exception) {
                        ErrorInfo error = new ErrorInfo();
             error.setErrorMessage(exception.getMessage());
                        error.setTimestamp(LocalDateTime.now());
                        error.setErrorCode(HttpStatus.NOT_FOUND.value());
                        return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
            }
}
