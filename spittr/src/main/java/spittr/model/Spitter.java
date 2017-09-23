package spittr.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created on 28.04.2017.
 * Represents a Spitter, which is user of Spittr
 * @author Artemis A. Sirosh
 */
public class Spitter {

    private Long id;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "{spitter.email.valid}")
    private String email;

    @NotNull
    @Size(min = 5, max = 16, message = "{spitter.username.size}")
    private String username;

    @NotNull
    @Size(min = 5, max = 25, message = "{spitter.password.size}")
    private String password;

    @NotNull
    @Size(min = 2, max = 30, message = "{spitter.firstName.size}")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30, message = "{spitter.lastName.size}")
    private String lastName;

    public Spitter() {
    }

    public Spitter(String email, String username, String password, String firstName, String lastName) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getEmail() {
        return email;
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
        return Objects.hashCode(id, email, username, firstName, lastName);
    }

    @Override
    public boolean equals(Object that) {
        if (that == null)
            return false;
        if (that instanceof Spitter) {
           Spitter thatSpitter = (Spitter)  that;
           return Objects.equal(this.id, thatSpitter.id) &&
                   Objects.equal(this.email, thatSpitter.email) &&
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
                .add("Email", email)
                .add("First name", firstName)
                .add("Last name", lastName)
                .toString();
    }
}
