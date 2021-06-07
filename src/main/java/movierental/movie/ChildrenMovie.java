package movierental.movie;

import movierental.Movie;
import movierental.MovieType;

public class ChildrenMovie extends Movie {

    public ChildrenMovie(String title) {
        super(title, MovieType.CHILDREN);
    }


}
