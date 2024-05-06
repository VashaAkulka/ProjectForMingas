package ru.sermyazhko.mingas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sermyazhko.mingas.model.Agreement;

import java.util.List;

@Repository
public interface AgreementRepository extends JpaRepository<Agreement, Long> {
    @Query("SELECT a FROM Agreement a WHERE NOT EXISTS (SELECT c FROM Consent c WHERE c.agreement = a AND c.user.id = :userId)")
    List<Agreement> findNotConsentAgreementByUserId(@Param("userId") Long userId);
}
