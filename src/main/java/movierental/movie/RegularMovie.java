package movierental.movie;

import movierental.Movie;
import movierental.MovieType;

public class RegularMovie extends Movie {

    public RegularMovie(String title) {
        super(title, MovieType.REGULAR);
    }

    @Override
    public double getPrice(int daysRented) {
        double basePrice = 2;
        if (daysRented > 2)
            return basePrice + (daysRented - 2) * 1.5;
        return basePrice;
    }
}
