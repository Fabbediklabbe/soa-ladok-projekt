package se.ltu.studieresultat.epok;

import jakarta.persistence.*;
import lombok.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "modules")
public class ModuleEntity {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
  String kurskod;
  String modulKod;
  String namn;
  boolean aktiv;
}
