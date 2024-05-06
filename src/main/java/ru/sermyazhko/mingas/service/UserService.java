package ru.sermyazhko.mingas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sermyazhko.mingas.dto.UserDTO;
import ru.sermyazhko.mingas.model.User;
import ru.sermyazhko.mingas.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User addOrFindUser(UserDTO userDTO) {
        User user = repository.findByNameAndMiddleNameAndLastNameAndPhoneNumberAndPosition (
                userDTO.getName(), userDTO.getMiddleName(), userDTO.getLastName(), userDTO.getPhoneNumber(), userDTO.getPosition()
        );

        if (user == null) {
            user = new User();
            user.setName(userDTO.getName());
            user.setMiddleName(userDTO.getMiddleName());
            user.setLastName(userDTO.getLastName());
            user.setPhoneNumber(userDTO.getPhoneNumber());
            user.setPosition(userDTO.getPosition());

            return repository.save(user);
        }

        return user;
    }

    public List<User> getAllUser() {
        return repository.findAll();
    }

    public void deleteUser(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new NoSuchElementException("No such agreement");
    }

    public void updateUser(UserDTO userDTO, Long id) {
        User user = repository.findById(id).orElseThrow(NoSuchElementException::new);
        user.setName(userDTO.getName());
        user.setPosition(userDTO.getPosition());
        user.setMiddleName(userDTO.getMiddleName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        repository.save(user);
    }

    public User getById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
