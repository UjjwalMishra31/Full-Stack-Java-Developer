package JDBC.VID1DEMO1;

import java.util.List;
import java.util.Optional;

public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository ownerRepository;
    private static final String OWNER_ALREADY_EXISTS = "Owner already exists with ownerId ";
    private static final String OWNER_NOT_FOUND = "Can't find owner with ownerId ";

    public OwnerServiceImpl() {
        this.ownerRepository = new OwnerRepositoryImpl();
    }

    @Override
    public void saveOwner(Owner owner) throws DuplicateOwnerException {
        Optional<Owner> existingOwner = ownerRepository.findOwner(owner.getId());
        if (existingOwner.isPresent()) {
            throw new DuplicateOwnerException(OWNER_ALREADY_EXISTS + owner.getId());
        }
        ownerRepository.saveOwner(owner);
    }

    @Override
    public Owner findOwner(int ownerId) throws OwnerNotFoundException {
        return ownerRepository.findOwner(ownerId)
                .orElseThrow(() -> new OwnerNotFoundException(OWNER_NOT_FOUND + ownerId));
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
        if (!ownerRepository.findOwner(ownerId).isPresent()) {
            throw new OwnerNotFoundException(OWNER_NOT_FOUND + ownerId);
        }
        ownerRepository.updatePetDetails(ownerId, petName);
    }

    @Override
    public void deleteOwner(int ownerId) throws OwnerNotFoundException {
        if (!ownerRepository.findOwner(ownerId).isPresent()) {
            throw new OwnerNotFoundException(OWNER_NOT_FOUND + ownerId);
        }
        ownerRepository.deleteOwner(ownerId);
    }

    @Override
    public List<Owner> findAllOwners() {
        return ownerRepository.findAllOwners();
    }
}
