package challenge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeRepository repository;
	@Autowired
	private RecipeCommentRepository commentRepository;

	@Override
	public Recipe save(Recipe recipe) {
		return repository.insert(recipe);
	}

	@Override
	public void update(String id, Recipe recipe) {
		repository.save(recipe);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
	}

	@Override
	public Recipe get(String id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Recipe> listByIngredient(String ingredient) {
		return null;
	}

	@Override
	public List<Recipe> search(String search) {
		return null;
	}

	@Override
	public void like(String id, String userId) {
		Recipe recipe = repository.findById(id).get();
		if(recipe.getLikes() != null){
			recipe.getLikes().add(userId);
		}else{
			recipe.setLikes(new ArrayList<>());
			recipe.getLikes().add(userId);
		}
		repository.save(recipe);
	}

	@Override
	public void unlike(String id, String userId) {
		Recipe recipe = repository.findById(id).get();
		if(recipe.getLikes() != null && !recipe.getLikes().isEmpty()){
			recipe.getLikes().remove(userId);
		}
		repository.save(recipe);
	}

	@Override
	public RecipeComment addComment(String id, RecipeComment comment) {
		RecipeComment savedComment = commentRepository.save(comment);
		Recipe recipe = repository.findById(id).get();
		if(recipe.getComments() == null){
			recipe.setComments(new ArrayList<>());
		}
		recipe.getComments().add(savedComment);
		repository.save(recipe);
		return savedComment;
	}

	@Override
	public void updateComment(String id, String commentId,
							  RecipeComment comment) {

	}

	@Override
	public void deleteComment(String id, String commentId) {

	}

}
