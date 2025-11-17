package proj.rest.mackimoveis.repositories;

import org.springframework.data.repository.CrudRepository;
import proj.rest.mackimoveis.models.Propriedade;

public interface PropriedadeRepository extends CrudRepository<Propriedade, Long> {
    
}
