package se.ltu.studieresultat.common.apimodels;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class StatusResponse {
    private String status; // "registrerad" eller "hinder"
    private String message; 
}
