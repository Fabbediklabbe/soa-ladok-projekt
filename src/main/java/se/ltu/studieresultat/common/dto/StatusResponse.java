package se.ltu.studieresultat.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class StatusResponse {
    private String status; // "registrerad" eller "hinder"
    private String message; 
}
