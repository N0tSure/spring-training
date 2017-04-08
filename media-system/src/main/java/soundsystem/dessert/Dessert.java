package soundsystem.dessert;

/**
 * Created by cresh on 22.01.17.
 */
public interface Dessert {
    default String tasty() {
        return String.format("This tasty %s ...", this.getClass().getSimpleName());
    }
}
