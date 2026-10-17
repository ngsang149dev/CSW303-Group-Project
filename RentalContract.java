import java.time.LocalDate;

public class RentalContract {
    int contractID;
    Property property;
    Tenant tenant;
    LocalDate startDate;
    LocalDate endDate;
    double rentAmount;
    boolean isActive;

    public RentalContract(int contractID, Property property, Tenant tenant, LocalDate startDate, LocalDate endDate) {
        this.contractID = contractID;
        this.property = property;
        this.startDate = startDate;
        this.endDate = endDate;
        isActive = true;
    }
}
