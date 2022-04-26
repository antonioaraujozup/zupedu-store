package br.com.zup.edu.store.api.aplicativo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@RestController
public class IncrementaDownloadsAplicativoController {

    private final AplicativoRepository repository;

    public IncrementaDownloadsAplicativoController(AplicativoRepository repository) {
        this.repository = repository;
    }

    @PatchMapping("/aplicativos/{id}/downloads")
    @Transactional
    public ResponseEntity<?> incrementa(@PathVariable Long id) {
        Aplicativo aplicativo = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aplicativo não cadastrado"));

        aplicativo.incrementaDownloads();

        repository.save(aplicativo);

        return ResponseEntity.ok(new AplicativoResponse(aplicativo));
    }
}
