package br.com.zup.edu.store.api.aplicativo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@RestController
public class IncrementaLikesAplicativoController {

    private final AplicativoRepository repository;

    public IncrementaLikesAplicativoController(AplicativoRepository repository) {
        this.repository = repository;
    }

    @PatchMapping("/aplicativos/{id}/likes")
    @Transactional
    public ResponseEntity<?> incrementa(@PathVariable Long id) {
        Aplicativo aplicativo = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aplicativo não encontrado"));

        aplicativo.incrementaLikes();

        repository.save(aplicativo);

        return ResponseEntity.ok(new AplicativoResponse(aplicativo));
    }
}
