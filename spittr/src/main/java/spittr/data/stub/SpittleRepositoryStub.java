package spittr.data.stub;

import org.springframework.stereotype.Component;
import spittr.data.SpittleRepository;
import spittr.model.Spittle;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created on 28.04.2017.
 * Simple stub, which emulate {@link spittr.data.SpittleRepository} work
 * @author Artemis A. Sirosh
 */
@Component
public class SpittleRepositoryStub implements SpittleRepository {

    private static final String[] SPITTLE_MSG = {
            "Spittles go fourth!",
            "Spittle spittle spittle",
            "Here another spittle",
            "Hello World! An Spittle!"
    };

    private final Random random;


    public SpittleRepositoryStub() {
        this.random = new Random(42);
    }

    @Override
    public Spittle findOne(long id) {
        return createSpittle(id);
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> result = new ArrayList<>(count);
        long ids = max + 1;
        for (int i = 0; i < count; i++, ids++) {
            result.add(createSpittle(ids));
        }
        return result;
    }

    private Spittle createSpittle(long id) {
        double latitude = Math.random() * 90;
        double longitude = Math.random() * 180;

        Spittle spittle = new Spittle(SPITTLE_MSG[random.nextInt(SPITTLE_MSG.length)], new Date(), latitude, longitude);

        try {

            Field idField = Spittle.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(spittle, id);
        } catch (NoSuchFieldException | IllegalAccessException exc) {
            throw new RuntimeException(exc);
        }

        return spittle;
    }
}
