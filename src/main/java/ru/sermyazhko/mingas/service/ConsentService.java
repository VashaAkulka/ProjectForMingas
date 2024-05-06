package ru.sermyazhko.mingas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sermyazhko.mingas.dto.ConsentDTO;
import ru.sermyazhko.mingas.model.Consent;
import ru.sermyazhko.mingas.repository.AgreementRepository;
import ru.sermyazhko.mingas.repository.ConsentRepository;
import ru.sermyazhko.mingas.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ConsentService {
    private final ConsentRepository repository;
    private final UserRepository userRepository;
    private final AgreementRepository agreementRepository;

    public void addConsent(ConsentDTO consentDTO) {
        Consent consent = new Consent();
        consent.setAgree(consentDTO.getAgree());
        consent.setFromData(consentDTO.getFromDate());
        consent.setToData(consentDTO.getToDate());
        consent.setUser(userRepository.findById(consentDTO.getUserId()).orElseThrow(NoSuchElementException::new));
        consent.setAgreement(agreementRepository.findById(consentDTO.getAgreementId()).orElseThrow(NoSuchElementException::new));

        repository.save(consent);
    }

    public List<Consent> getUserConsent(Long userId) {
        return repository.findConsentByUserId(userId);
    }

    public void deleteConsent(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new NoSuchElementException("No such agreement");
    }
}
