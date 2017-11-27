import com.mashape.unirest.http.HttpResponse;
import entities.Comments;
import entities.Items;
import entities.Replies;
import entities.YouTubeCommentThread;

import java.util.ArrayList;

public class ComentsMain {
    public static void main(String[] args) {
       // System.out.println(YouTubeDataGet.getActivitiesString("v_CxtJRVzBY",1).getBody());
        ArrayList<String> videoIds = new ArrayList<>();
        videoIds.add("v_CxtJRVzBY");
        for (String id: videoIds
             ) {
            HttpResponse<YouTubeCommentThread> response = YouTubeDataGet.getActivities(id,10);

            System.out.println("video id = " + videoIds);
            YouTubeCommentThread body = response.getBody();
            for (int i = 0; i<body.items.size(); i++) {
                Items item = body.items.get(i);
                System.out.println("Имя автора " + body.items.get(i).snippet.topLevelComment.snippet.authorDisplayName);
                System.out.println("Текст сообщения " + body.items.get(i).snippet.topLevelComment.snippet.textDisplay);
                System.out.println("Кол-во лайков " + body.items.get(i).snippet.topLevelComment.snippet.likeCount);
                System.out.println("Дата последнего изменения " + body.items.get(i).snippet.topLevelComment.snippet.publishedAt);
                boolean changed = false;
                if (!body.items.get(i).snippet.topLevelComment.snippet.publishedAt.equals(body.items.get(i).snippet.topLevelComment.snippet.updatedAt))
                    changed = true;

                System.out.println("Был ли комментарий отредактирован (true/false) " + changed);
                for (int j = 0; j < body.items.get(i).replies.comments.size(); j++) {
                    Comments comments = item.replies.comments.get(j);
                    if (body.items.get(i).replies.comments.get(j) != null) {
                        changed = false;

                        System.out.println("Автор ответа " + comments.snippet.authorDisplayName);
                        System.out.println("Текст ответа " + comments.snippet.textDisplay);
                        System.out.println("Количество лайков ответа " + comments.snippet.likeCount);
                        System.out.println("Дата изменения ответа " + comments.snippet.publishedAt);
                        if (!comments.snippet.publishedAt.equals(comments.snippet.updatedAt))
                            changed = true;

                        System.out.println("Был ли ответ отредактирован (true/false) " + changed);
                    }
                }
            }
        }



    //            Комментарии должны быть сгруппированы в разделы. Один раздел = одно видео. Должно быть выведено имя видео.

    }
}
