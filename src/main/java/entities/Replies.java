package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Replies {
    public ArrayList<Comments> comments = new ArrayList<Comments>();
}
