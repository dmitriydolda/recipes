package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    final private RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Optional<Recipe> getRecipeById(long id) {
        System.out.println("id" + id);
        return recipeRepository.findById(id);
    }

    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(long id) {
        recipeRepository.deleteById(id);
    }

    public boolean recipeExists(long id) {
        return recipeRepository.existsById(id);
    }

    public Optional<Recipe> updateRecipe(long id, Recipe recipe) {
        Optional<Recipe> recipeToUpdate = recipeRepository.findById(id);

        if (recipeToUpdate.isPresent()) {
            recipeToUpdate.get().setName(recipe.getName());
            recipeToUpdate.get().setCategory(recipe.getCategory());
            recipeToUpdate.get().setDescription(recipe.getDescription());
            recipeToUpdate.get().setDirections(recipe.getDirections());
            recipeToUpdate.get().setIngredients(recipe.getIngredients());
            recipeToUpdate.get().setDate(LocalDateTime.now());
            recipeRepository.save(recipeToUpdate.get());
        }

        return recipeToUpdate;
    }

    public List<Recipe> getRecipeByName(String name) {
        return recipeRepository.findByNameContainsIgnoreCase(name);
    }

    public List<Recipe> getRecipeByCategory(String category) {
        return recipeRepository.findByCategoryIgnoreCase(category);
    }
}
