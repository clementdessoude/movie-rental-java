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
}
