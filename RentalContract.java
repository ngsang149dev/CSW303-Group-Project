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

        if (!property.isAvailable()) {
            throw new IllegalStateException("Property is not available");
        }
        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("End date must be later than start date.");
        }
        this.contractID = contractID;
        this.property = property;
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
        this.contractID = contractID;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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

}
