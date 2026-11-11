package controller;

import model.*;

public class RentalController {
    public Property createProperty(PropertyOwner owner, int propertyID, String description, double rentalRate) {
        return owner.createProperty(propertyID, description, rentalRate);
    }

    public RentalContract rentProperty(Tenant tenant, Property property, String startDate, String endDate,
            double rentAmount) {
        return tenant.rentProperty(property, startDate, endDate, rentAmount);
    }

    public void terminateContract(RentalContract contract) {
        contract.terminateContract();
    }
}