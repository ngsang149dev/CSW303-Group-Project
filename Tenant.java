import java.util.ArrayList;
import java.time.LocalDate;
public class Tenant extends User {
    private ArrayList<RentalContract> rentalContracts;

    public Tenant(int userID, String firstName, String lastName, String email) {
        super(userID, firstName, lastName, email);
        rentalContracts = new ArrayList<>();
    }

    public RentalContract rentProperty(int contractID, Property property, LocalDate startDate, LocalDate endDate){
        RentalContract rentalContract;     
        rentalContract = new RentalContract(contractID, property, this, startDate, endDate);
        if (rentalContract!=null)
            rentalContracts.add(rentalContract);
        return rentalContract;
    }

    public ArrayList<RentalContract> getRentalContracts(){
        return rentalContracts;
    }
}
