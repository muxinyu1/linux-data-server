package work.oldust.dataserver.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collation = "reviews")
public class Review {
    @Id private String id;
    private String targetPost;
    private String date;
    private String username;
    private String content;
}
