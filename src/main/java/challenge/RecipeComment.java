package challenge;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe para mapear o comentário da receita no MongoDB
 *
 */
@Document(collection = "comments")
public class RecipeComment {

    @Id
    private String id;
    private String comment;

    public RecipeComment() {
    }

    public RecipeComment(String id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
