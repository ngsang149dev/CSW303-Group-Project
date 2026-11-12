package model;

public class Property {
    private int propertyID;
    private String description;
    private double rentalRate;
    private boolean isAvailable;

    public Property(int propertyID, String description, double rentalRate) {
        this.propertyID = propertyID;
        this.description = description;
        if (rentalRate <= 0) {
            throw new IllegalArgumentException("Rental rate must be greater than 0.");
        }
        this.rentalRate = rentalRate;
        isAvailable = true;
    }

    public void updateDescription(String desc) {
        this.description = desc;
    }

    public void updateRentalRate(double rent) {
        if (rent <= 0) {
            throw new IllegalArgumentException("Rental rate must be greater than 0.");
        }
        this.rentalRate = rent;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
