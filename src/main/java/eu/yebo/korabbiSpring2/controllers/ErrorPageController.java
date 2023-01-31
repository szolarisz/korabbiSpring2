package eu.yebo.korabbiSpring2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Map;

@Controller
public class ErrorPageController implements ErrorController {

    private static final String ERR_PATH="/error";

    private ErrorAttributes errorAttributes;

    @Autowired
    public void setErrorAttributes(ErrorAttributes errorAttributes){
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(ERR_PATH)
        public String error(Model model, HttpServletRequest request){
        ServletWebRequest reqAttr = new ServletWebRequest(request);
       // ErrorAttributeOptions options =new ErrorAttributes();
        Map<String, Object> error = this.errorAttributes.getErrorAttributes(reqAttr, ErrorAttributeOptions.defaults() );

        model.addAttribute("timestamp", error.get("timestamp"));
        model.addAttribute("error", error.get("error"));
        model.addAttribute("message", error.get("message"));
        model.addAttribute("path", error.get("path"));
        model.addAttribute("status", error.get("status"));

        //System.out.println( error.get("status").getClass() +" " +error.get("status") );
        if(error.get("status").toString().equals("404")){
            return notFound(model, request);
        }

        return "/detailedError";
        }

        public String notFound(Model model, HttpServletRequest request){
            return "/404";
        }

}
