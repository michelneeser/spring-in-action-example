package com.michelneeser.tacos.data;

import com.michelneeser.tacos.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {


}