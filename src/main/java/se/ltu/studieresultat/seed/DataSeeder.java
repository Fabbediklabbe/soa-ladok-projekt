package se.ltu.studieresultat.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.ltu.studieresultat.epok.ModuleEntity;
import se.ltu.studieresultat.epok.ModuleRepository;
import se.ltu.studieresultat.studentits.StudentEntity;
import se.ltu.studieresultat.studentits.StudentRepository;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
  private final ModuleRepository modRepo;
  private final StudentRepository stuRepo;

  @Override public void run(String... args) {
    modRepo.save(new ModuleEntity(null, "D0031N", "0005", "Inlämningsuppgift", true));
    modRepo.save(new ModuleEntity(null, "D0031N", "0006", "Tentamen", true));
    stuRepo.save(new StudentEntity(null, "sveedz-4", "19940613-2345"));
    stuRepo.save(new StudentEntity(null, "axelv-1", "20000101-1234"));
  }
}
