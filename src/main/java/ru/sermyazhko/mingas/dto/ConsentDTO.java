package ru.sermyazhko.mingas.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsentDTO {
    private LocalDate toDate;
    private LocalDate fromDate;
    private Long userId;
    private Long agreementId;
    private Boolean agree;
}
