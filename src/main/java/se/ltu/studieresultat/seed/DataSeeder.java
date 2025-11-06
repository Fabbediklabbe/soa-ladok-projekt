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

    // Kurs D0031N SOA
    modRepo.save(new ModuleEntity(null, "D0031N", "0005", "Inlämningsuppgift", true));
    modRepo.save(new ModuleEntity(null, "D0031N", "0006", "Tentamen", true));

    // Kurs D0025E Data Mining
    modRepo.save(new ModuleEntity(null, "D0025E", "0005", "Inlämningsuppgift", true));
    modRepo.save(new ModuleEntity(null, "D0025E", "0006", "Tentamen", true));

    // Kurs D0005N Databaser II
    modRepo.save(new ModuleEntity(null, "D0005N", "0005", "Inlämningsuppgift", true));
    modRepo.save(new ModuleEntity(null, "D0005N", "0006", "Tentamen", true));


    // Studenter
    stuRepo.save(new StudentEntity(null, "fabnys-3", "20020921-4321"));
    stuRepo.save(new StudentEntity(null, "axevik-3", "19992912-1234"));
    stuRepo.save(new StudentEntity(null, "jonhje-2", "20010415-5678"));
    stuRepo.save(new StudentEntity(null, "petvik-5", "19981130-7890"));
    stuRepo.save(new StudentEntity(null, "matohv-7", "19970707-4567"));
  }
}
