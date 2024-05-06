package ru.sermyazhko.mingas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sermyazhko.mingas.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndMiddleNameAndLastNameAndPhoneNumberAndPosition (String name, String middleName, String lastName, String phoneNumber, String position);
}
