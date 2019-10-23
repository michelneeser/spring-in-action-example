package com.michelneeser.tacos.web;

import com.michelneeser.tacos.Ingredient;
import com.michelneeser.tacos.Taco;
import com.michelneeser.tacos.data.IngredientRepository;
import com.michelneeser.tacos.data.JdbcIngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    private IngredientRepository repo;

    @Autowired
    public DesignTacoController(IngredientRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String showDesignForm(Model model) {

        /*
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("LETC", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("TMTO", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("JACK", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Monterrey", Ingredient.Type.CHEESE),
                new Ingredient("CHED", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );
         */

        List<Ingredient> ingredients = new ArrayList<>();
        repo.findAll().forEach(ingredient -> ingredients.add(ingredient));

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        model.addAttribute("design", new Taco());

        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors) {
        if (errors.hasErrors()) {
            return "design";
        }
        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream().filter(i -> i.getType() == type).collect(Collectors.toList());
    }

}