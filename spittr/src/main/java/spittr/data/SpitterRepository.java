package spittr.data;

import spittr.model.Spitter;

/**
 * Created on 28.04.2017.
 * Deal with {@link Spitter}
 * @author Artemis A. Sirosh
 */
public interface SpitterRepository {

    /**
     * Saves new Spitter object
     * @param spitter object, which should be saved
     * @return saved Spitter
     */
    Spitter save(Spitter spitter);

}
