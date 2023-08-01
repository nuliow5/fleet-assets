package lt.gerasimovas.fleetassets.services;

import lombok.AllArgsConstructor;
import lt.gerasimovas.fleetassets.converters.UserMapper;
import lt.gerasimovas.fleetassets.dto.UserDTO;
import lt.gerasimovas.fleetassets.entities.UserEntity;
import lt.gerasimovas.fleetassets.enumes.Role;
import lt.gerasimovas.fleetassets.repositories.UserEntityRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class UserEntityService implements Crude<UserDTO, UserEntity, Role> {

    private UserEntityRepository userRepository;

    @Override
    public List<UserDTO> getAllDto(Pageable pageable, Role role) {
        if (role != null) {
            return UserMapper.convertPageToDtoList(this.userRepository.findByRole(role, pageable));
        }
        return UserMapper.fromEntitiesListToDtoList(this.userRepository.findAll());
    }

    @Override
    public UserDTO getById(Long id) {
        return UserMapper.fromEntityToDto(this.userRepository.findById(id).get());
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        if (this.userRepository.findByUsername(userDTO.getUsername()) == null) {
            UserEntity user = UserMapper.fromDtoToEntity(userDTO);
            this.userRepository.save(user);
            return userDTO;
        } else {
            throw new IllegalArgumentException("User by username all ready existing");
        }
    }

    @Override
    public UserDTO update(UserDTO userDTO) throws NoSuchFieldException {
        UserEntity userForUpdate = this.userRepository.findById(userDTO.getId()).get();

        if (userDTO.getUsername() != null && this.userRepository.findByUsername(userDTO.getUsername()) == null) {
            userForUpdate.setUsername(userDTO.getUsername());
        } else {
            throw new IllegalArgumentException("User by username all ready existing");
        }

        if (userDTO.getRole() != null) {
            userForUpdate.setRole(userDTO.getRole());
        }

        this.userRepository.save(userForUpdate);

        return UserMapper.fromEntityToDto(userForUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if (this.userRepository.findById(id) != null){
            this.userRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("User by this id not found");
        }
    }
}
