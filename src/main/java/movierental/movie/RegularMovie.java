package movierental.movie;

import movierental.Movie;
import movierental.MovieType;

public class RegularMovie extends Movie {

    public RegularMovie(String title) {
        super(title, MovieType.REGULAR);
    }


}
