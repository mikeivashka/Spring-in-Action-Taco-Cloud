package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.beans.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
