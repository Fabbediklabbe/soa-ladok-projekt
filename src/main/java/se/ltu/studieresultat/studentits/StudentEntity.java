package se.ltu.studieresultat.studentits;

import jakarta.persistence.*;
import lombok.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "students")
public class StudentEntity {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
  String anvandarnamn;   // "sveedz-4"
  String personnummer;   // "19940613-2345"
}
