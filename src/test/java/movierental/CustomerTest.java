package movierental;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import org.junit.Test;

public class CustomerTest {

    @Test
    public void should_handle_empty_customer() {
        Customer customer = new Customer("Bob");

        String expected = "" +
            "Rental Record for Bob\n" +
            "Amount owed is 0.0\n" +
            "You earned 0 frequent renter points";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void should_handle_regular_movies() {
        Customer customer = new Customer("Bob");

        customer.addRental(new Rental(new Movie("Jaws", MovieType.REGULAR), 2));

        String expected = "" +
            "Rental Record for Bob\n" +
            "\tJaws\t2.0\n" +
            "Amount owed is 2.0\n" +
            "You earned 1 frequent renter points";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void should_handle_regular_movies_with_more_than_two_days() {
        Customer customer = new Customer("Bob");

        customer.addRental(new Rental(new Movie("Jaws", MovieType.REGULAR), 3));

        String expected = "" +
            "Rental Record for Bob\n" +
            "\tJaws\t3.5\n" +
            "Amount owed is 3.5\n" +
            "You earned 1 frequent renter points";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void test() {
        Customer customer = new Customer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", MovieType.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", MovieType.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", MovieType.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", MovieType.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", MovieType.CHILDREN), 3));
        customer.addRental(new Rental(new Movie("Toy Story", MovieType.CHILDREN), 4));

        String expected = "" +
                "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tBambi\t1.5\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 19.0\n" +
                "You earned 7 frequent renter points";

        assertEquals(expected, customer.statement());
    }
}
