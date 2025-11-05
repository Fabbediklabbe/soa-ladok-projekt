package se.ltu.studieresultat.studentits;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.ltu.studieresultat.common.dto.PersonnummerResponse;

@RestController
@RequestMapping("/studentits")
@RequiredArgsConstructor
public class StudentController {

  private final StudentRepository repo;

  @GetMapping(value = "/personnummer/{anv}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonnummerResponse> getPersnr(@PathVariable String anv) {
    return repo.findByAnvandarnamn(anv)
      .map(s -> ResponseEntity.ok(new PersonnummerResponse(s.getPersonnummer())))
      .orElse(ResponseEntity.notFound().build());
  }
}
