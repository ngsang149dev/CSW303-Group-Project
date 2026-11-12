package view;

import controller.RentalController;
import model.*;
import java.util.Scanner;
import java.time.LocalDate;

public class ConsoleView {

    private RentalController controller;
    private Scanner sc;
    private PropertyOwner owner;
    private Tenant tenant;

    public ConsoleView(PropertyOwner owner, Tenant tenant) {
        controller = new RentalController();
        sc = new Scanner(System.in);
        this.owner = owner;
        this.tenant = tenant;
    }

    public void displayMenu() {
        int choice = 0;

        do {
            System.out.println("\n1. Create property");
            System.out.println("2. Rent property");
            System.out.println("3. Terminate contract");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        createProperty();
                        break;
                    case 2:
                        rentProperty();
                        break;
                    case 3:
                        terminateContract();
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 4);
    }

    private void createProperty() {
        try {
            System.out.print("Property ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Description: ");
            String description = sc.nextLine();

            System.out.print("Rental rate: ");
            double rate = sc.nextDouble();
            sc.nextLine();

            Property p = controller.createProperty(owner, id, description, rate);

            if (p != null)
                System.out.println("Property created successfully!");
            else
                System.out.println("Failed to create property.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void rentProperty() {
        try {
            System.out.print("Property ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            Property selected = null;

            for (Property p : owner.getOwnedProperties()) {
                if (p.getPropertyID() == id && p.isAvailable()) {
                    selected = p;
                    break;
                }
            }

            if (selected == null) {
                System.out.println("Property not found or unavailable.");
                return;
            }

            System.out.print("Contract ID: ");
            int contractID = sc.nextInt();
            sc.nextLine();

            System.out.print("Start date (YYYY-MM-DD): ");
            LocalDate start = LocalDate.parse(sc.nextLine());

            System.out.print("End date (YYYY-MM-DD): ");
            LocalDate end = LocalDate.parse(sc.nextLine());

            controller.rentProperty(tenant, contractID,
                    selected, start, end);

            System.out.println("Property rented successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void terminateContract() {
         try {
            System.out.println("Active contracts:");

            for (RentalContract c : tenant.getRentalContracts()) {
                if (c.isActive())
                    System.out.println("Contract ID: " + c.getContractID());
            }

            System.out.print("Contract ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            for (RentalContract c : tenant.getRentalContracts()) {
                if (c.getContractID() == id && c.isActive()) {
                    controller.terminateContract(c);
                    System.out.println("Contract terminated successfully!");
                    return;
                }
            }

            System.out.println("Contract not found or already terminated.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}