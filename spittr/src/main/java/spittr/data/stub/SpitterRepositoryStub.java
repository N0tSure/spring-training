package spittr.data.stub;

import org.springframework.stereotype.Component;
import spittr.data.SpitterRepository;
import spittr.exceptions.DuplicateSpitterUsernameException;
import spittr.model.Spitter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created on 28.04.2017.
 * Simple stub, which emulate {@link spittr.data.SpitterRepository} work
 * @author Artemis A. Sirosh
 */
@Component
public class SpitterRepositoryStub implements SpitterRepository {

    private final Random random;
    private final Map<String, Spitter> storage;

    public SpitterRepositoryStub() {
        this.random = new Random(42);
        this.storage = new HashMap<>();
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

        if (storage.containsKey(spitter.getUsername())) {
            throw new DuplicateSpitterUsernameException(spitter.toString());
        }

        storage.put(spitter.getUsername(), spitter);
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        return storage.get(username);
    }
}
