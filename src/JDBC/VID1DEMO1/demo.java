package JDBC.VID1DEMO1;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class demo {
    private OwnerService ownerService;

    public static void main(String[] args) throws IOException {
        demo demo = new demo();
        demo.run();
    }

    public void run() {
        ownerService = new OwnerServiceImpl();

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("Welcome to Petistaan");
                int menuOption = InputUtil.acceptMenuOption(scanner);

                switch (menuOption) {
                    case 1:
                        Owner owner = InputUtil.acceptOwnerDetailsToSave(scanner);
                        ownerService.saveOwner(owner);
                        System.out.println("Owner has been saved successfully.");
                        break;

                    case 2:
                        int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
                        owner = ownerService.findOwner(ownerId);
                        System.out.println("Owner has been fetched successfully.");
                        System.out.println(owner);
                        break;

                    case 3:
                        ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
                        String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
                        ownerService.updatePetDetails(ownerId, petName);
                        System.out.println("Pet details of owner have been updated successfully.");
                        break;

                    case 4:
                        ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
                        ownerService.deleteOwner(ownerId);
                        System.out.println("Owner has been deleted successfully.");
                        break;

                    case 5:
                        List<Owner> owners = ownerService.findAllOwners();
                        System.out.println("There are " + owners.size() + " owners.");
                        owners.forEach(System.out::println);
                        break;

                    default:
                        System.out.println("Invalid option entered.");
                }
            } while (InputUtil.wantToContinue(scanner));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
