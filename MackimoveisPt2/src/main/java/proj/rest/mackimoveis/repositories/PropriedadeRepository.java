package proj.rest.mackimoveis.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import proj.rest.mackimoveis.models.Propriedade;

public interface PropriedadeRepository extends CrudRepository<Propriedade, Long> {
    List<Propriedade> findByDisponivelTrue();
    List<Propriedade> findByLocalizacaoContainingIgnoreCaseAndDisponivelTrue(String localizacao);
}
