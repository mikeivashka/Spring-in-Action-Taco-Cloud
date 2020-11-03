package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.beans.Ingredient;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    Ingredient getById(String id);
    List<Ingredient> findAll();
}
