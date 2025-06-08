package JDBC.VID1DEMO1;

import java.util.List;

public interface OwnerService {
    void saveOwner(Owner owner) throws DuplicateOwnerException;
    Owner findOwner(int ownerId) throws OwnerNotFoundException;
    void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;
    void deleteOwner(int ownerId) throws OwnerNotFoundException;
    List<Owner> findAllOwners();
}
