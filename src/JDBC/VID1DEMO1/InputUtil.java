package JDBC.VID1DEMO1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static int acceptMenuOption(Scanner scanner) {
        System.out.println("1. Save Owner");
        System.out.println("2. Find Owner");
        System.out.println("3. Update Pet Details");
        System.out.println("4. Delete Owner");
        System.out.println("5. Find All Owners");
        System.out.print("Enter your option: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static Owner acceptOwnerDetailsToSave(Scanner scanner) {
        Owner owner = new Owner();
        System.out.print("Enter Owner ID: ");
        owner.setId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter First Name: ");
        owner.setFirstName(scanner.nextLine());

        System.out.print("Enter Last Name: ");
        owner.setLastName(scanner.nextLine());

        System.out.print("Enter Gender (M/F): ");
        owner.setGender(Gender.valueOf(scanner.nextLine().toUpperCase()));

        System.out.print("Enter City: ");
        owner.setCity(scanner.nextLine());

        System.out.print("Enter State: ");
        owner.setState(scanner.nextLine());

        System.out.print("Enter Mobile Number: ");
        owner.setMobileNumber(scanner.nextLine());

        System.out.print("Enter Email ID: ");
        owner.setEmailId(scanner.nextLine());

        System.out.print("Enter Pet ID: ");
        owner.setPetId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter Pet Name: ");
        owner.setPetName(scanner.nextLine());

        System.out.print("Enter Pet Birth Date (dd-MM-yyyy): ");
        owner.setPetBirthDate(convertStringToDate(scanner.nextLine()));

        System.out.print("Enter Pet Gender (M/F): ");
        owner.setPetGender(Gender.valueOf(scanner.nextLine().toUpperCase()));

        System.out.print("Enter Pet Type (DOG, CAT, FISH, BIRD, RABBIT): ");
        owner.setPetType(PetType.valueOf(scanner.nextLine().toUpperCase()));

        return owner;
    }

    public static int acceptOwnerIdToOperate(Scanner scanner) {
        System.out.print("Enter Owner ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String acceptPetDetailsToUpdate(Scanner scanner) {
        System.out.print("Enter New Pet Name: ");
        return scanner.nextLine();
    }

    public static boolean wantToContinue(Scanner scanner) {
        System.out.print("Do you want to continue? (yes/no): ");
        return scanner.nextLine().equalsIgnoreCase("yes");
    }

    public static LocalDate convertStringToDate(String date) {
        return LocalDate.parse(date, FORMATTER);
    }
}
