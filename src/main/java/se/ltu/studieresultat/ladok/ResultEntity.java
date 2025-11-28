package se.ltu.studieresultat.ladok;

import jakarta.persistence.*;
import lombok.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "results")
public class ResultEntity {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
  String personnummer;
  String kurskod;
  String modul;
  String datum;
  String betyg;
  String status;
}
