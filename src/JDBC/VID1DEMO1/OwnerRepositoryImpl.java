package JDBC.VID1DEMO1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OwnerRepositoryImpl implements OwnerRepository {
    private static List<Owner> ownerList;

    static {
        ownerList = new ArrayList<>();

        Owner owner = new Owner();
        owner.setId(1);
        owner.setFirstName("Abhishek");
        owner.setLastName("Verma");
        owner.setGender(Gender.M);
        owner.setCity("Chandigarh");
        owner.setState("Chandigarh");
        owner.setMobileNumber("9876543210");
        owner.setEmailId("abhishekvermaa10@gmail.com");
        owner.setPetId(1);
        owner.setPetName("Mitthu");
        owner.setPetBirthDate(InputUtil.convertStringToDate("07-03-2022"));
        owner.setPetGender(Gender.M);
        owner.setPetType(PetType.BIRD);

        ownerList.add(owner);
    }

    @Override
    public void saveOwner(Owner owner) {
        ownerList.add(owner);
    }

    @Override
    public Optional<Owner> findOwner(int ownerId) {
        return ownerList.stream()
                .filter(owner -> owner.getId() == ownerId)
                .findFirst();
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) {
        findOwner(ownerId).ifPresent(owner -> owner.setPetName(petName));
    }

    @Override
    public void deleteOwner(int ownerId) {
        ownerList.removeIf(owner -> owner.getId() == ownerId);
    }

    @Override
    public List<Owner> findAllOwners() {
        return ownerList;
    }
}
