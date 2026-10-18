import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PropertyOwner owner = new PropertyOwner(1, "Anna", "Nguyen", "anna@example.com");
        Tenant tenant = new Tenant(2, "Minh", "Tran", "minh@example.com");
        Property property = owner.createProperty(101, "Apartment A101, two bedrooms", 5000);
        RentalContract contract = tenant.rentProperty(1001, property, LocalDate.of(2026, 11, 1), LocalDate.of(2027, 10, 31));

        StringBuilder sb = new StringBuilder();
        sb.append(owner.getFullName()).append("\n").
        append(owner.getOwnedProperties().size()).append("\n").
        append(tenant.getRentalContracts().size()).append("\n").
        append(property.isAvailable()).append("\n").
        append(contract.isActive()).append("\n").
        append(contract.getRentAmount());
        System.out.println(sb);

        StringBuilder sb2 = new StringBuilder();
        property.updateRentalRate(5500);
        sb2.append("Property: Rental rate = " + property.getRentalRate()).append("\n").
        append("Contract: Rent amount = " + contract.getRentAmount());
        contract.terminate();

        sb2.append("\nContract: Is active = " + contract.isActive()).append("\n").
        append("Property: Is available = " + property.isAvailable());
        System.out.println(sb2);
        }

}
