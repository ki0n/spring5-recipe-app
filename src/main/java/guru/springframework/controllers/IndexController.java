package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;
    //private CategoryRepository categoryRepository;
    //private UnitOfMeasureRepository unitOfMeasureRepository;

    //public IndexController(RecipeService recipeService, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        //this.recipeService = recipeService;
        //this.categoryRepository = categoryRepository;
        //this.unitOfMeasureRepository = unitOfMeasureRepository;
    //}

    public IndexController(RecipeService recipeService) {

        this.recipeService = recipeService;
    }


    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting Index page");

       // Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        // Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        //System.out.println("Cat Id is: " + categoryOptional.get().getId());
        //System.out.println("UOM Id is: " + unitOfMeasureOptional.get().getId());

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
