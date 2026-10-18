import java.util.ArrayList;

public class PropertyOwner extends User {
    private ArrayList<Property> ownedProperties;

    public PropertyOwner(int userID, String firstName, String lastName, String email) {
        super(userID, firstName, lastName, email);
        ownedProperties = new ArrayList<>();
    }

    public Property createProperty(int propertyID, String description, double rentalRate) {
        Property property;
        property = new Property(propertyID, description, rentalRate);
        if (property != null)
            ownedProperties.add(property);
        return property;
    }

    public ArrayList<Property> getOwnedProperties() {
        return ownedProperties;
    }
}
