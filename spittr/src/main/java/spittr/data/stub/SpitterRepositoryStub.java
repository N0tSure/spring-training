package spittr.data.stub;

import org.springframework.stereotype.Component;
import spittr.data.SpitterRepository;
import spittr.model.Spitter;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created on 28.04.2017.
 * Simple stub, which emulate {@link spittr.data.SpitterRepository} work
 * @author Artemis A. Sirosh
 */
@Component
public class SpitterRepositoryStub implements SpitterRepository {

    private final Random random;

    public SpitterRepositoryStub() {
        this.random = new Random(42);
    }

    @Override
    public Spitter save(Spitter spitter) {
        long id = random.nextLong();

        try {
            Field idField = Spitter.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(spitter, id);
        } catch (NoSuchFieldException | IllegalAccessException exc) {
            throw new RuntimeException(exc);
        }

        return spitter;
    }

}
