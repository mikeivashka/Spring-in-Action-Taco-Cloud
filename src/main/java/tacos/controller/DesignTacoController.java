package tacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tacos.beans.Ingredient;
import tacos.beans.Ingredient.Type;
import tacos.beans.Taco;
import tacos.data.IngredientRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/design")
@Slf4j
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    DesignTacoController(IngredientRepository ingredientRepo){
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(ingredients::add);
        Type[] types = Ingredient.Type.values();
        for (Type type : types){
            model.addAttribute(type.toString().toLowerCase(), ingredients.stream().filter(t -> t.getType() == type).toArray());
        }
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco taco, Errors errors){
        //Save the taco design
        if(errors.hasErrors()){
            log.info("Invalid input");
            return "design";
        }
        log.info("Processing design: " + taco.toString());
        return "redirect:/orders/current";
    }
}
