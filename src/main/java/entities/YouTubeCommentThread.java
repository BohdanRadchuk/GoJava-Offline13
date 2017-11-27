package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YouTubeCommentThread {
    public ArrayList<Items> items = new ArrayList<>();
}
