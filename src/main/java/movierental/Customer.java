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
        double totalAmount = rentals.stream().mapToDouble(this::getRentalAmount).sum();
        int frequentRenterPoints = rentals.stream().mapToInt(this::getFrequentRenterPoints).sum();

        String header = "Rental Record for " + getName() + "\n";
        String rentalsStatements = getRentalsStatements();
        String footer = getStatementFooter(totalAmount, frequentRenterPoints);

        return header + rentalsStatements + footer;
    }

    private String getRentalsStatements() {
        StringBuilder builder = new StringBuilder();
        for (Rental each : rentals) {
            builder.append(getRentalFiguresStatement(each, getRentalAmount(each)));
        }
        return builder.toString();
    }

    private String getStatementFooter(
        double totalAmount,
        int frequentRenterPoints
    ) {
        String amountOwnedSummary =  "Amount owed is " + totalAmount;
        String frequentRenterPointSummary = "You earned " + frequentRenterPoints + " frequent renter points";

        return amountOwnedSummary + "\n" + frequentRenterPointSummary;
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
