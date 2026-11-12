package controller;

import model.*;
import java.time.LocalDate;
public class RentalController {
    public Property createProperty(PropertyOwner owner, int propertyID, String description, double rentalRate) {
        return owner.createProperty(propertyID, description, rentalRate);
    }

    public RentalContract rentProperty(Tenant tenant, int contractID, Property property, LocalDate startDate, LocalDate endDate) {
        return tenant.rentProperty(contractID, property, startDate, endDate);
    }
    public void terminateContract(RentalContract contract) {
        contract.terminate();
    }
}
