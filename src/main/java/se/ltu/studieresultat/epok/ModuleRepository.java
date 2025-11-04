package se.ltu.studieresultat.epok;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ModuleRepository extends JpaRepository<ModuleEntity, Long> {
  List<ModuleEntity> findByKurskodAndAktivTrue(String kurskod);
}
