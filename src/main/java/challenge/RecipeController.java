package challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeController {

	@Autowired
	private RecipeService service;

	@PostMapping("/recipe")
	public Recipe save(@RequestBody Recipe recipe) {
		return service.save(recipe);
	}

	@PutMapping("/recipe/{id}")
	public void update(@PathVariable String id, @RequestBody Recipe recipe) {
		service.update(id, recipe);
	}

	@DeleteMapping("/recipe/{id}")
	public void delete(@PathVariable String id) {
		service.delete(id);
	}

	@GetMapping("/recipe/{id}")
	public Recipe get(@PathVariable String id) {
		return service.get(id);
	}

	@GetMapping("/recipe/ingredient")
	public List<Recipe> listByIngredient(List<String> ingredients) {
		return service.listByIngredient(ingredients.toString());
	}

	@GetMapping("/recipe/search")
	public List<Recipe> search() {
		return service.search(null);
	}

	@PostMapping("/recipe/{id}/like/{userId}")
	public void like(@PathVariable String id, @PathVariable String userId) {
		service.like(id, userId);
	}

	@DeleteMapping("/recipe/{id}/like/{userId}")
	public void unlike(@PathVariable String id, @PathVariable String userId) {
		service.unlike(id, userId);
	}

	@PostMapping("/recipe/{id}/comment")
	public RecipeComment addComment(@PathVariable String id, @RequestBody RecipeComment comment) {
		return service.addComment(id, comment);
	}

	@PutMapping("/recipe/{id}/comment/{commentId}")
	public void updateComment(@PathVariable String id, @PathVariable String commentId, @RequestBody RecipeComment comment) {
		service.updateComment(id, commentId, comment);
	}

	@DeleteMapping("/recipe/{id}/comment/{commentId}")
	public void deleteComment(@PathVariable String id, @PathVariable String commentId) {
		service.deleteComment(id, commentId);
	}

}
