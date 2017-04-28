package spittr.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Created on 28.04.2017.
 * Represents a Spitter, which is user of Spittr
 * @author Artemis A. Sirosh
 */
public class Spitter {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public Spitter() {
    }

    public Spitter(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, username, firstName, lastName);
    }

    @Override
    public boolean equals(Object that) {
        if (that == null)
            return false;
        if (that instanceof Spitter) {
           Spitter thatSpitter = (Spitter)  that;
           return Objects.equal(this.id, thatSpitter.id) &&
                   Objects.equal(this.username, thatSpitter.username) &&
                   Objects.equal(this.firstName, thatSpitter.firstName) &&
                   Objects.equal(this.lastName, thatSpitter.lastName);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Username", username)
                .add("First name", firstName)
                .add("Last name", lastName)
                .toString();
    }
}
