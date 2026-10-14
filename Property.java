public class Property {
    private int PropertyID;
    private String Description;
    private double RentalRate;
    private boolean IsAvailable;

    public Property(int propertyID, String description, double rentalRate) {
        if (rentalRate <= 0) {
            throw new IllegalArgumentException("Error: Rental rate must be greater than zero.");
        }
        this.PropertyID = propertyID;
        this.Description = description;
        this.RentalRate = rentalRate;
        this.IsAvailable = true;
    }

    public void UpdateDescription(String description) {
        this.Description = description;
    }

    public void UpdateRentalRate(double rentalRate) {
        if (rentalRate <= 0) {
            throw new IllegalArgumentException("Error: New rental rate must be greater than zero.");
        }
        this.RentalRate = rentalRate;
    }

    public int getPropertyID() {
        return PropertyID;
    }

    public String getDescription() {
        return Description;
    }

    public double getRentalRate() {
        return RentalRate;
    }

    public boolean isAvailable() {
        return IsAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.IsAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Property{" +
                "PropertyID=" + PropertyID + ", Description='" + Description + '\'' + ", RentalRate=" + RentalRate + ", IsAvailable=" + IsAvailable + '}';
    }
}