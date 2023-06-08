package work.oldust.dataserver.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collation = "posts")
public class Post {
    @Id private String id;
    private String date;
    private String owner;
    private String title;
    private String content;
    private List<String> reviews;
}
