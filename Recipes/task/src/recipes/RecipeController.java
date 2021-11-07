package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@Validated
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("/api/recipe/{id}")
    public Recipe getRecipe(@PathVariable long id) {
        Optional<Recipe> recipe = recipeService.getRecipeById(id);
        if (recipe.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return recipe.get();
        }
    }

    @GetMapping("/api/recipe/search")
    public List<Recipe> searchRecipe(@RequestParam(required = false) Map<String, String> params) {

        List<Recipe> resultList = List.of();
        if (params.size() == 1) {
            if (params.containsKey("category")) {
                resultList = recipeService.getRecipeByCategory(params.get("category"));
            } else if (params.containsKey("name")) {
                resultList = recipeService.getRecipeByName(params.get("name"));
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Collections.sort(resultList);

        return resultList;

    }

    @PostMapping("/api/recipe/new")
    public ResponseEntity<Object> setRecipe(@RequestBody @Valid Recipe recipe, Principal principal) {

        Recipe newRecipe = recipe;
        newRecipe.setDate(LocalDateTime.now());
        Optional<User> currentUser = userInfoRepository.getUserByEmail(principal.getName());
        if (currentUser.isPresent()) {
            newRecipe.setUser(currentUser.get());
            newRecipe = recipeService.saveRecipe(newRecipe);
        }

        return ResponseEntity.ok(Collections.singletonMap("id", newRecipe.getId()));
    }

    @DeleteMapping("/api/recipe/{id}")
    public ResponseEntity<Object> deleteRecipe(@PathVariable long id, Principal principal) {

        if (recipeService.recipeExists(id)) {
            if (canEditRecipe(principal.getName(), id)) {
                recipeService.deleteRecipe(id);
                return ResponseEntity.noContent().build();
            } else {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/api/recipe/{id}")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody @Valid Recipe recipe,
                                               @PathVariable long id, Principal principal) {
        if (recipeService.recipeExists(id)) {
            if (canEditRecipe(principal.getName(), id)) {
                recipeService.updateRecipe(id, recipe);
                return ResponseEntity.noContent().build();
            } else {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
}

    private boolean canEditRecipe(String userName, long recipeId) {
        boolean canEdit;

        Optional<Recipe> recipeToEdit = recipeService.getRecipeById(recipeId);
        Optional<User> currentUser = userInfoRepository.getUserByEmail(userName);

        if (!recipeToEdit.isPresent() || !currentUser.isPresent()) {
            canEdit = false;
        } else {
            canEdit = recipeToEdit.get().getUser().getId() == currentUser.get().getId();
        }

        return canEdit;
    }
}
