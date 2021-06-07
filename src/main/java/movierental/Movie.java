package movierental;

public abstract class Movie {

    private final String title;
    private final MovieType type;

    public Movie(String title, MovieType type) {
        this.title = title;
        this.type = type;
    }

    public MovieType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public abstract double getPrice(int daysRented);
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    };
}
