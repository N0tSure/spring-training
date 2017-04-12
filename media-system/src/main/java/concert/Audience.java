package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created on 10.04.2017.
 * A performance isn’t a performance without an audience.
 * @author Artemis A. Sirosh
 */
@Aspect
@Component
public class Audience {
    private static final Logger LOGGER = LoggerFactory.getLogger(Audience.class);

    @Pointcut("execution(** concert.Performance.perform(..)) && bean(woodStockFestival)")
    public void performance() {}

    @Before("performance()")
    public void silencePhones() {
        LOGGER.info("Silencing phones");
    }

    @Before("performance()")
    public void takeSeats() {
        LOGGER.info("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        LOGGER.info("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        LOGGER.info("Demanding refund");
    }

    @Around("execution(** concert.Performance.perform(..)) && bean(theaterDrama)")
    public void watchDrama(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            LOGGER.info("Silencing phone before drama");
            LOGGER.info("Taking seats in theater");
            proceedingJoinPoint.proceed();
            LOGGER.info("[Applause]");
        } catch (Throwable throwable) {
            LOGGER.info("[Disappoint silence");
        }
    }
}
