package proj.rest.mackimoveis.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import proj.rest.mackimoveis.models.Propriedade;
import proj.rest.mackimoveis.repositories.PropriedadeRepository;

@RestController
@RequestMapping("/api/propriedades")
public class PropriedadeController {
    private final PropriedadeRepository repo;

    public PropriedadeController(PropriedadeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Propriedade> getPropriedades() {
        return repo.findAll();
    }

    @GetMapping("/disponiveis")
    public List<Propriedade> disponiveis() {
        return repo.findByDisponivelTrue();
    }

    @GetMapping("/{id}")
    public Propriedade getPropriedade(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Propriedade create(@RequestBody Propriedade p) {
        return repo.save(p);
    }

    @PutMapping("/{id}")
    public Propriedade update(@PathVariable Long id, @RequestBody Propriedade p) {
        p.setId(id);
        return repo.save(p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}