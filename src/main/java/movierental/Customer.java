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
        double totalAmount = rentals.stream().mapToDouble(Rental::getRentalAmount).sum();
        int frequentRenterPoints = rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();

        String header = "Rental Record for " + getName() + "\n";
        String rentalsStatements = getRentalsStatements();
        String footer = getStatementFooter(totalAmount, frequentRenterPoints);

        return header + rentalsStatements + footer;
    }

    private String getRentalsStatements() {
        StringBuilder builder = new StringBuilder();
        for (Rental each : rentals) {
            builder.append(getRentalFiguresStatement(each, each.getRentalAmount()));
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

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }
}
