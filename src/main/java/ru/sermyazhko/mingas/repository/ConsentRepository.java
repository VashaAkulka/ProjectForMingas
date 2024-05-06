package ru.sermyazhko.mingas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sermyazhko.mingas.model.Consent;

import java.util.List;

@Repository
public interface ConsentRepository extends JpaRepository<Consent, Long> {
    @Query("Select c from Consent c join c.user u where u.id = :userId")
    List<Consent> findConsentByUserId(@Param("userId") Long userId);
}
