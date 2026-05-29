package com.example.hnk24cntt2_dotiendat008.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("""
        execution(* com.example.hnk24cntt2_dotiendat008.service.MenuItemService.create(..))
        || execution(* com.example.hnk24cntt2_dotiendat008.service.MenuItemService.update(..))
    """)
    public void logMethod(JoinPoint jp) {

        log.info(
                "Method called: {}",
                jp.getSignature().getName()
        );
    }
}