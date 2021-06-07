package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String statement() {
        double totalAmount = 0;

        StringBuilder builder = new StringBuilder();
        builder.append("Rental Record for ").append(getName()).append("\n");

        for (Rental each : rentals) {
            double thisAmount = getRentalAmount(each);

            builder.append(getRentalFiguresStatement(each, thisAmount));
            totalAmount += thisAmount;
        }

        int frequentRenterPoints = rentals.stream().mapToInt(this::getFrequentRenterPoints).sum();

        // add footer lines
        builder
            .append("Amount owed is ")
            .append(totalAmount)
            .append("\n");
        builder
            .append("You earned ")
            .append(frequentRenterPoints)
            .append(" frequent renter points");

        return builder.toString();
    }

    private String getRentalFiguresStatement(Rental each, double thisAmount) {
        return "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
    }

    private int getFrequentRenterPoints(Rental each) {
        int frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
            frequentRenterPoints++;

        return frequentRenterPoints;
    }

    private double getRentalAmount(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2)
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3)
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }
}
