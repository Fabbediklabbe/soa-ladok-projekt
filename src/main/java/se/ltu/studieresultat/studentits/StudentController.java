package se.ltu.studieresultat.studentits;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/studentits")
@RequiredArgsConstructor
public class StudentController {
  private final StudentRepository repo;

  @GetMapping("/personnummer/{anv}")
  public ResponseEntity<String> getPersnr(@PathVariable String anv) {
    return repo.findByAnvandarnamn(anv)
      .map(s -> ResponseEntity.ok(s.getPersonnummer()))
      .orElse(ResponseEntity.notFound().build());
  }
}
