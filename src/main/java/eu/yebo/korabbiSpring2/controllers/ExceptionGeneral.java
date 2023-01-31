package eu.yebo.korabbiSpring2.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGeneral {

    @ExceptionHandler
    public String exception(Exception exc, Model model){
        model.addAttribute("exception", exc);
        //System.out.println(exc);
        return "myExceptionHandler";
    }
}
