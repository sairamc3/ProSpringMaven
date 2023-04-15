package net.javaguides.SpringAop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;

}
