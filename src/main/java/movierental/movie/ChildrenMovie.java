package movierental.movie;

import movierental.MovieType;

public class ChildrenMovie extends Movie {

    public ChildrenMovie(String title) {
        super(title, MovieType.CHILDREN);
    }

    @Override
    public double getPrice(int daysRented) {
        double basePrice = 1.5;

        if (daysRented > 3) {
            return basePrice + (daysRented - 3) * 1.5;
        }

        return basePrice;
    }
}
