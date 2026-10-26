import java.time.LocalDate;

public class RentalContract {
    private int contractID;
    private Property property;
    private Tenant tenant;
    private LocalDate startDate;
    private LocalDate endDate;
    private double rentAmount;
    private boolean isActive;

    public RentalContract(int contractID, Property property, Tenant tenant, LocalDate startDate, LocalDate endDate) {
        validateContractID(contractID);
        validateProperty(property);
        validateTenant(tenant);
        validateDates(startDate, endDate);

        this.contractID = contractID;
        this.property = property;
        this.tenant = tenant;
        this.startDate = startDate;
        this.endDate = endDate;
        isActive = true;
        this.rentAmount = property.getRentalRate();
        property.setAvailable(false);

    }

    public void terminate() {
        if (!isActive) {
            return;
        }
        isActive = false;
        property.setAvailable(true);
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        validateContractID(contractID);
        this.contractID = contractID;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        validateProperty(property);
        this.property = property;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        validateTenant(tenant);
        this.tenant = tenant;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        validateDates(startDate, this.endDate);
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        validateDates(this.startDate, endDate);
        this.endDate = endDate;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    private void validateContractID(int contractID) {
        if (contractID <= 0) {
            throw new IllegalArgumentException("Contract ID must be a positive integer.");
        }
    }

    private void validateProperty(Property property) {
        if (property == null) {
            throw new IllegalArgumentException("Property must not be null.");
        }
        //reject a *different* unavailable property.
        if (property != this.property && !property.isAvailable()) {
            throw new IllegalStateException("Property is not available.");
        }
    }

    private void validateTenant(Tenant tenant) {
        if (tenant == null) {
            throw new IllegalArgumentException("Tenant must not be null.");
        }
    }

    private void validateDates(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start date and end date must not be null.");
        }
        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("End date must be later than start date.");
        }
    }

}
