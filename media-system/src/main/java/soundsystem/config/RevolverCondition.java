package soundsystem.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.support.EmbeddedValueResolutionSupport;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

/**
 * Created by cresh on 14.01.17.
 */
public class RevolverCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        System.out.println("Found property 'revolver': " + environment.containsProperty("revolver.show"));
        return environment.containsProperty("revolver.show");
    }
}
