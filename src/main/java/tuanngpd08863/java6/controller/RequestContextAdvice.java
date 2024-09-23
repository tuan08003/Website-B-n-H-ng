package tuanngpd08863.java6.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RequestContextAdvice {

    @ModelAttribute("request")
    public HttpServletRequest request(HttpServletRequest request) {
        return request;
    }
}
