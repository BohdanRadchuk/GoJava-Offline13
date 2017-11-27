package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
    public String id;
    public Snippet snippet;
    public Replies replies;

}
