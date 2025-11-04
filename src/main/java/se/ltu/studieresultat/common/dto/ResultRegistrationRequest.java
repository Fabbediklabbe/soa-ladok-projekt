package se.ltu.studieresultat.common.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ResultRegistrationRequest {
    @NotBlank String personnummer;  // "19940613-2345"
    @NotBlank String kurskod;       // "D0031N"
    @NotBlank String modul;         // "0005"
    @NotBlank String datum;         // "2025-10-20" (ISO yyyy-MM-dd)
    @NotBlank String betyg;         // "A", "B", ... eller "U/G"
}
