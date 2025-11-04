package se.ltu.studieresultat.epok;

import jakarta.persistence.*;
import lombok.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "modules")
public class ModuleEntity {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
  String kurskod;      // "D0031N"
  String modulKod;     // "0005"
  String namn;         // "Inlämningsuppgift"
  boolean aktiv;
}
