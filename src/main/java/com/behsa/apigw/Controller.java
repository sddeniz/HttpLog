package com.behsa.apigw;


import org.apache.logging.log4j.LogManager;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@Validated

@RequestMapping("api/request")
public class Controller {
    @Autowired
    private RequestRepository requestRepository;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Controller.class);


    @PostMapping("send")
    ResponseDto<?> httpLog(@Validated @RequestBody RequestMessage requestMessage) {
        if (requestMessage == null) {
            return null;
        }
        Logger.getLogger("done");
        logger.info("done");


        return new ResponseDto<>(requestRepository.save(requestMessage), HttpStatus.OK_200);

    }


}


