package se.ltu.studieresultat.ladok;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<ResultEntity, Long> {
  boolean existsByPersonnummerAndKurskodAndModul(String p, String k, String m);
}
