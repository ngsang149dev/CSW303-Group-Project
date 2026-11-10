package controller;

import model.*;

public class RentalController {
    public void createProperty(PropertyOwner owner, int propertyID, String description, double rentalRate) {
        owner.createProperty(propertyID, description, rentalRate);
    }
}
