package se.ltu.studieresultat.itsstudent;

import jakarta.persistence.*;
import lombok.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "students")
public class StudentEntity {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
  String anvandarnamn;
  String personnummer;
}
