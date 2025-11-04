package se.ltu.studieresultat.studentits;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
  Optional<StudentEntity> findByAnvandarnamn(String anvandarnamn);
}
