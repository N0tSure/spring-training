package concert;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

    @Before("execution(** concert.Performance.perform(..))")
    public void silencePhones() {
        LOGGER.info("Silencing phones");
    }

    @Before("execution(** concert.Performance.perform(..))")
    public void takeSeats() {
        LOGGER.info("Taking seats");
    }

    @AfterReturning("execution(** concert.Performance.perform(..))")
    public void applause() {
        LOGGER.info("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("execution(** concert.Performance.perform(..))")
    public void demandRefund() {
        LOGGER.info("Demanding refund");
    }
}
