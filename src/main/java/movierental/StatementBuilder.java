package movierental;

public abstract class StatementBuilder {
    String getStatement(Customer customer) {
        double totalAmount = customer.getRentals().stream().mapToDouble(Rental::getRentalAmount).sum();
        int frequentRenterPoints = customer.getRentals().stream().mapToInt(Rental::getFrequentRenterPoints).sum();

        String header = getHeader(customer);
        String rentalsStatements = getRentalsStatements(customer);
        String footer = getFooter(totalAmount, frequentRenterPoints);

        return header + rentalsStatements + footer;
    }

    protected abstract String getHeader(Customer customer);
    protected abstract String getRentalsStatements(Customer customer);
    protected abstract String getFooter(double totalAmount, int frequentRenterPoints);
}
