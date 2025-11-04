package se.ltu.studieresultat.epok;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/epok")
@RequiredArgsConstructor
public class EpokController {
  private final ModuleRepository repo;

  @GetMapping("/modul/{kurskod}")
  public List<String> getModuler(@PathVariable String kurskod) {
    return repo.findByKurskodAndAktivTrue(kurskod)
               .stream()
               .map(m -> m.getModulKod() + " " + m.getNamn())
               .toList();
    }
}