package com.ricky.example.handle;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ricky
 * @create 2019-09-03 20:48
 */
@RestControllerAdvice
public class UserExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    Object HandleException(Exception e, HttpServletRequest httpServletRequest){
        Map<String,Object> map = new HashMap<>();
        map.put("code",100);
        map.put("msg",e.getMessage());
        map.put("url",httpServletRequest.getRequestURL());
        return map;
    }

    @ExceptionHandler(value = MyException.class)
    Object HandleMyException(MyException e,HttpServletRequest httpServletRequest){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("code",e.getCode());
        modelAndView.addObject("msg",e.getMsg());
        return modelAndView;
    }
}
