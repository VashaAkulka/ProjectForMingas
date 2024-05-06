package ru.sermyazhko.mingas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sermyazhko.mingas.dto.AgreementDTO;
import ru.sermyazhko.mingas.model.Agreement;
import ru.sermyazhko.mingas.model.User;
import ru.sermyazhko.mingas.repository.AgreementRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AgreementService {

    private final AgreementRepository repository;

    public void addAgreement(AgreementDTO agreementDTO) {
        Agreement agreement = new Agreement();
        agreement.setContent(agreementDTO.getContent());
        agreement.setTitle(agreementDTO.getTitle());
        agreement.setTarget(agreementDTO.getTarget());

        repository.save(agreement);
    }

    public void deleteAgreement(Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
        else throw new NoSuchElementException("No such agreement");
    }

    public List<Agreement> getAllAgreement() {
        return repository.findAll();
    }

    public List<Agreement> getNotConsentAgreementByUser (Long userId) {
        return repository.findNotConsentAgreementByUserId(userId);
    }

    public void updateAgreement(AgreementDTO agreementDTO, Long id) {
        Agreement agreement = repository.findById(id).orElseThrow(NoSuchElementException::new);
        agreement.setTarget(agreementDTO.getTarget());
        agreement.setTitle(agreementDTO.getTitle());
        agreement.setContent(agreementDTO.getContent());
        repository.save(agreement);
    }

    public Agreement getById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
