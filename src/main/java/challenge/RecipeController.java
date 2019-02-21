package challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

	@Autowired
	private RecipeService service;

	@PostMapping("/")
	public Recipe save(Recipe recipe) {
		return service.save(service.save(recipe));
	}

	@PutMapping("/{id}")
	public void update(@PathVariable String id, @RequestBody Recipe recipe) {
		service.update(id, recipe);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		service.delete(id);
	}

	@GetMapping("/{id}")
	public Recipe get(@PathVariable String id) {
		return service.get(id);
	}

	@GetMapping("/ingredient")
	public List<Recipe> listByIngredient(List<String> ingredients) {

		return service.listByIngredient(ingredients.toString());
	}

	@GetMapping("/search")
	public List<Recipe> search() {
		return service.search(null);
	}

	@PostMapping("/{id}/like/{userId}")
	public void like(@PathVariable String id, @PathVariable String userId) {
		service.like(id, userId);
	}

	@DeleteMapping("/{id}/like/{userId}")
	public void unlike(@PathVariable String id, @PathVariable String userId) {
		service.unlike(id, userId);
	}

	@PostMapping("/{id}/comment")
	public RecipeComment addComment(@PathVariable String id, @RequestBody RecipeComment comment) {
		return service.addComment(id, comment);
	}

	@PutMapping("/{id}/comment/{commentId}")
	public void updateComment(@PathVariable String id, @PathVariable String commentId, @RequestBody RecipeComment comment) {
		service.updateComment(id, commentId, comment);
	}

	@DeleteMapping("/{id}/comment/{commentId}")
	public void deleteComment(@PathVariable String id, @PathVariable String commentId) {
		service.deleteComment(id, commentId);
	}

}
