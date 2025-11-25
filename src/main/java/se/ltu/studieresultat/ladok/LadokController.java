package se.ltu.studieresultat.ladok;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.ltu.studieresultat.common.apimodels.ResultRegistrationRequest;
import se.ltu.studieresultat.common.apimodels.StatusResponse;

@RestController
@RequestMapping("/ladok")
@RequiredArgsConstructor
public class LadokController {
  private final ResultRepository repo;

  @PostMapping("/resultat")
  public ResponseEntity<StatusResponse> registrera(@Valid @RequestBody ResultRegistrationRequest req) {
    // Enkel validering för prototyp
    if (repo.existsByPersonnummerAndKurskodAndModul(req.getPersonnummer(), req.getKurskod(), req.getModul())) {
      return ResponseEntity.ok(new StatusResponse("hinder", "Redan registrerat"));
    }
    var saved = repo.save(new ResultEntity(null,
      req.getPersonnummer(), req.getKurskod(), req.getModul(),
      req.getDatum(), req.getBetyg(), "registrerad"));

    return ResponseEntity.ok(new StatusResponse(saved.getStatus(), "OK"));
    }
}
