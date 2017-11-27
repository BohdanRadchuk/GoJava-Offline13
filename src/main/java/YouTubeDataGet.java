import com.fasterxml.jackson.core.JsonProcessingException;

import com.mashape.unirest.http.HttpResponse;

import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import entities.YouTubeCommentThread;

import java.io.IOException;

public class YouTubeDataGet {
    private static final String YOU_TUBE = "https://www.googleapis.com/youtube/v3/{method}";
    private static final String API_KEY = "AIzaSyCl0nW-_pC68yOaRAvktYuByEKxYITPYNk";

    static {// Only one time
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


        public static HttpResponse<String> getActivitiesString(String videoId, int maxResults) {
        try {
            return Unirest.get(YOU_TUBE)
                    .routeParam("method", "commentThreads")
                    .queryString("videoId", videoId)
                    .queryString("maxResults", maxResults)
                    .queryString("part", "snippet,replies")
                    .queryString("key", API_KEY)
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HttpResponse<YouTubeCommentThread> getActivities(String videoId , int maxResults) {
        try {
            return Unirest.get(YOU_TUBE)
                    .routeParam("method", "commentThreads")
                    .queryString("videoId", videoId)
                    .queryString("maxResults", maxResults)
                    .queryString("part", "snippet,replies")
                    .queryString("key", API_KEY)
                    .asObject(YouTubeCommentThread.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }
}

