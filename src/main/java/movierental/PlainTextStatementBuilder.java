package movierental;

public class PlainTextStatementBuilder extends StatementBuilder {
    @Override
    protected String getHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

    @Override
    protected String getRentalsStatements(Customer customer) {
        StringBuilder builder = new StringBuilder();
        for (Rental each : customer.getRentals()) {
            builder.append(getRentalFiguresStatement(each, each.getRentalAmount()));
        }
        return builder.toString();
    }

    @Override
    protected String getFooter(
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
