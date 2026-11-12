
import controller.RentalController;
import model.PropertyOwner;
import model.Tenant;
import view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        PropertyOwner owner = new PropertyOwner(1, "Anna", "Nguyen", "anna@example.com");
        Tenant tenant = new Tenant(2, "Minh", "Tran", "minh@example.com");

        RentalController controller = new RentalController();
        ConsoleView view = new ConsoleView(controller, owner, tenant);
        view.displayMenu();

        //Completed Flow
        //   CHOOSE 1
        //      Property ID: 101
        //      Description: Apartment  A101
        //      Rental rate: 5000
        //   Result
        //      Property created successfully!
        //      Is available = true
        //   CHOOSE 2
        //      Property ID: 101
        //      Contract ID: 1001
        //      Start date (YYYY-MM-DD): 2026-11-01
        //      End date (YYYY-MM-DD): 2027-10-31
        //   Result
        //      Property rented successfully!
        //      Is available = false
        //   CHOOSE 3
        //      Active contracts:
        //      Contract ID: 1001
        //      Contract ID: 1001
        //   Result
        //      Contract terminated successfully!
        //      Is available = true
        //   CHOOSE 4
        //   Exit and Goodbye
        //Invalid Operation
        //   CHOOSE 1
        //      Property ID: 102
        //      Description: Apartment  A102
        //      Rental rate: 0
        //   Result
        //      Error: Rental rate must be greater than 0.  
    }
}
