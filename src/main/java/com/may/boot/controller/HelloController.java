package com.may.boot.controller;

import com.may.boot.exception.CustomError;
import com.may.boot.exception.MyException1;
import com.may.boot.exception.MyException2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by May on 3/24/17.
 */
@RestController
@RequestMapping("/hellos")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/sayHello")
    public String sayHello(String name) {
        logger.info("请求/hellos/sayHello" + ",name=" + name);
        return "hello , " + name + ",study springboot ";
    }


    @RequestMapping("/ex1")
    public String ex1() throws MyException1 {
        throw new MyException1("参数不对");
    }

    @RequestMapping("/ex2")
    public String ex2() throws MyException2 {
        throw new MyException2("test ex2");
    }

    @RequestMapping("testEx")
    public String testExceptionController() {
        throw new NullPointerException("空指针异常");
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity controllerExceptionHandler(HttpServletRequest req, Exception e) {

        logger.error("---ControllerException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        HttpStatus status = getStatus(req);
        return new ResponseEntity(new CustomError(e.getMessage(), status.value()), status);

        // return e.getMessage();
    }



    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (null == statusCode) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
