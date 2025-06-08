package JDBC.VID1DEMO1;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {
    void saveOwner(Owner owner);
    Optional<Owner> findOwner(int ownerId);
    void updatePetDetails(int ownerId, String petName);
    void deleteOwner(int ownerId);
    List<Owner> findAllOwners();
}
