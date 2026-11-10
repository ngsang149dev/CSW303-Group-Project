
import java.util.regex.Pattern;

abstract class User {

    private int userID;
    private String firstName;
    private String lastName;
    private String email;

    public User(int userID, String firstName, String lastName, String email) {
        validateUserID(userID);
        validateName(firstName, "First name");
        validateName(lastName, "Last name");
        validateEmail(email);

        this.userID = userID;
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.email = email;
    }

    public String getFullName() {
        return "%s %s".formatted(this.firstName, this.lastName);
    }

    public void updateProfile(String firstName, String lastName, String email) {
        validateName(firstName, "First name");
        validateName(lastName, "Last name");
        validateEmail(email);

        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.email = email;

    }

    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    private static final Pattern NAME_PATTERN
            = Pattern.compile("^[\\p{L} .'-]+$");

    private static final Pattern EMAIL_PATTERN
            = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    private void validateUserID(int userID) {
        if (userID <= 0) {
            throw new IllegalArgumentException("UserID must be a positive integer.");
        }
    }

    private void validateName(String name, String fieldName) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must not be empty.");
        }
        if (!NAME_PATTERN.matcher(name.trim()).matches()) {
            throw new IllegalArgumentException(fieldName + " contains invalid characters.");
        }
    }

    private void validateEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }
}
