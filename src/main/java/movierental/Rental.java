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
        double thisAmount = 0;
        switch (getMovie().getType()) {
            case REGULAR:
                thisAmount += 2;
                if (getDaysRented() > 2)
                    thisAmount += (getDaysRented() - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += getDaysRented() * 3;
                break;
            case CHILDREN:
                thisAmount += 1.5;
                if (getDaysRented() > 3)
                    thisAmount += (getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((getMovie().getType() == MovieType.NEW_RELEASE) && getDaysRented() > 1)
            frequentRenterPoints++;

        return frequentRenterPoints;
    }
}
