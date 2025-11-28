package se.ltu.studieresultat.common.apimodels;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ResultRegistrationRequest {
    @NotBlank String personnummer;
    @NotBlank String kurskod;
    @NotBlank String modul;
    @NotBlank String datum;
    @NotBlank String betyg;
}
