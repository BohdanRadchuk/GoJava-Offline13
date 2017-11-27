package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentSnippet {

    public String authorDisplayName;
    public String textDisplay;
    public int likeCount;
    public String publishedAt;
    public String updatedAt;
}
