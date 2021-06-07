package movierental;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getRentalAmount() {
        return movie.getPrice(getDaysRented());
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((getMovie().getType() == MovieType.NEW_RELEASE) && getDaysRented() > 1)
            frequentRenterPoints++;

        return frequentRenterPoints;
    }
}
