package exercicies;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.Comment;
import entities.Post;

public class ExPost {
  public static void main () {
    List<Post> posts = new ArrayList<>();
    Post post = new Post(
      Instant.now(),
      "Traveling to New Zeeland",
      "I'm going to visit this wonderful country!",
      12
    );

    post.addComent(
      new Comment("Hava a nice trip")
    );

    post.addComent(
      new Comment("Won that's aweasome!")
    );

    posts.add(post);

    Post post2 = new Post(
      Instant.now(),
      "Good night guys",
      "See you tomorrow",
      5
    );

    post2.addComent(
      new Comment("Good night")
    );

    post2.addComent(
      new Comment("May the force be with you")
    );

    posts.add(post2);

    for (Post item: posts) {
      System.out.println(item.getTitle());

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
      LocalDateTime localDateTime = LocalDateTime.ofInstant(item.getMoment(), ZoneId.systemDefault());

      System.out.println(item.getLikes() + " Likes - " + localDateTime.format(formatter));
      System.out.println(item.getContent());
      System.out.println("Comments");
      for (Comment comment: item.getComments()) {
        System.out.println(comment.getText());
      }

      System.out.println();
    }
  }
}
