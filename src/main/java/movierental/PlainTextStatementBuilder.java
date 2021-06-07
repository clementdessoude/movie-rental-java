package movierental;

public class PlainTextStatementBuilder extends StatementBuilder {
    @Override
    public String getStatement(Customer customer) {
        double totalAmount = customer.getRentals().stream().mapToDouble(Rental::getRentalAmount).sum();
        int frequentRenterPoints = customer.getRentals().stream().mapToInt(Rental::getFrequentRenterPoints).sum();

        String header = "Rental Record for " + customer.getName() + "\n";
        String rentalsStatements = getRentalsStatements(customer);
        String footer = getStatementFooter(totalAmount, frequentRenterPoints);

        return header + rentalsStatements + footer;
    }

    private String getRentalsStatements(Customer customer) {
        StringBuilder builder = new StringBuilder();
        for (Rental each : customer.getRentals()) {
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
}
