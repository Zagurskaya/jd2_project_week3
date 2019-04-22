package com.gmail.zagurskaya.service.aspect;

import com.gmail.zagurskaya.service.service.impl.AuditItemServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//@Aspect
@Component
public class ItemAuditAspect {

    private final Logger logger = LogManager.getLogger(ItemAuditAspect.class);
    AuditItemServiceImpl auditItemService = new AuditItemServiceImpl();

    LocalDate date = LocalDate.now();

    public String getFormattedLocalDateAndTime(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00.000"));
    }

    @Pointcut("execution(* com.gmail.zagurskaya.controller.impl.ItemServiceImpl.*(..))")
    public void auditItem() {
    }


    @After("auditItem()")
    public void afterCallAtMethodAdd(){
//        auditItemService.save();
        logger.info("end time = "+date);
    }
}
