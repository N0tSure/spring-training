package concert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 14.04.2017.
 * @author Artemis A. Sirosh
 */
public aspect CriticAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(CriticAspect.class);

    private CriticismEngine criticismEngine;

    public CriticAspect() {
        // no - op
    }

    pointcut performance() : execution(* perform(..));

//    afterReturning() : performance() {
//        LOGGER.info(criticismEngine.getCriticism());
//    }

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
