package concert;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created on 12.04.2017.
 *
 * @author Artemis A. Sirosh
 */
@Aspect
@Component
public class EncoreIntroducer {

    @DeclareParents(value = "concert.Performance+", defaultImpl = Encore.class)
    public static Encoreable encoreable;

}
