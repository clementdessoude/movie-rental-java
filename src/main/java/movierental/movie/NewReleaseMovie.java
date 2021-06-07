package movierental.movie;

import movierental.Movie;
import movierental.MovieType;

public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title, MovieType.NEW_RELEASE);
    }

    @Override
    public double getPrice(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        int additionalFrequentRenterPoints = daysRented > 1 ? 1 : 0;
        return super.getFrequentRenterPoints(daysRented) + additionalFrequentRenterPoints;
    }
}
