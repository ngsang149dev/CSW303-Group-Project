import java.util.ArrayList;

public class PropertyOwner extends User {
    private ArrayList<Property> ownedProperties;

    public PropertyOwner(int userID, String firstName, String lastName, String email) {
        super(userID, firstName, lastName, email);
        ownedProperties = new ArrayList<>();
    }

    public Property createProperty(int propertyID, String description, double rentalRate) {
        try {
            Property property = new Property(propertyID, description, rentalRate);

            ownedProperties.add(property);

            return property;
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi tạo tài sản: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Property> getOwnedProperties() {
        return ownedProperties;
    }
}