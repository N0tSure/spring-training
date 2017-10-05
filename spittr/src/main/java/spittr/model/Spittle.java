package spittr.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.Date;

/**
 * Created on 23 Apr, 2017.
 * Represent a spittle
 * @author Artemis A. Sirosh
 */
public class Spittle {

    private final Long id;
    private final String message;
    private final Date timestamp;
    private Double latitude;
    private Double longitude;

    public Spittle(String message, Date timestamp) {
        this(message, timestamp, null, null);
    }

    public Spittle(String message, Date timestamp, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object that) {
        return that instanceof Spittle &&
                Objects.equal(this.id, ((Spittle) that).id) &&
                Objects.equal(this.timestamp, ((Spittle) that).timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, timestamp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("message", this.getMessage())
                .add("date", this.getTimestamp())
                .add("latitude", this.getLatitude())
                .add("longitude", this.getLongitude())
                .toString();
    }
}
