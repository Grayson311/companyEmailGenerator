import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String email;
    private String alternateEmail;
    private String companySuffix = ".company.com";
    private int defaultPasswordLength = 10;
    private int mailboxCapacity = 500;

    public Email (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("NEW EMPLOYEE: " + this.firstName + " " + this.lastName);

        this.department = setDepartment();

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
        System.out.println("Your email is: " + email);
    }

    private String setDepartment() {
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\n" +
                "Enter Department Code: ");
        Scanner scan = new Scanner(System.in);
        int departmentChoice = scan.nextInt();
        switch (departmentChoice) {
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "acct";
            default:
                return "";
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWZYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int randomNumber = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randomNumber);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {return mailboxCapacity;}
    public String getAlternateEmail() {return alternateEmail;}
}
