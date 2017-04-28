package spittr.data;

import spittr.model.Spittle;

import java.util.List;

/**
 * Created on 23 Apr, 2017.
 * Operates with Spittles
 * @author Artemis A. Sirosh
 */
public interface SpittleRepository {

    /**
     * Find one spittle
     * @param id identifier of spittle
     * @return founded spittle
     */
    Spittle findOne(long id);

    /**
     * Find some most recent spittles
     * @param max Spittle
     *            ID that represents the maximum ID of any Spittle
     *            that should be returned
     * @param count indicates how many spittles to return
     * @return list of found spittles
     */
    List<Spittle> findSpittles(long max, int count);

}
