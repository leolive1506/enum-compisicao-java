package entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
  private Instant moment;
  private String title;
  private String content;
  private Integer likes;

  private List<Comment> comments = new ArrayList<>();

  public Post() {}

  public Post(Instant moment, String title, String content, Integer likes) {
    this.moment = moment;
    this.title = title;
    this.content = content;
    this.likes = likes;
  }

  public Instant getMoment() {
    return moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getLikes() {
    return likes;
  }

  public void setLikes(Integer likes) {
    this.likes = likes;
  }

  public List<Comment> getComments() {
    return this.comments;
  }

  public void addComent(Comment comment) {
    this.comments.add(comment);
  }

  public void removeComent(Comment comment) {
    this.comments.remove(comment);
  }

  @Override
  public String toString() {
    StringBuilder string = new StringBuilder();
    string.append(title + "\n");
    string.append(likes);
    string.append(" Likes - ");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime localDateTime = LocalDateTime.ofInstant(moment, ZoneId.systemDefault());

    string.append(localDateTime.format(formatter) + "\n");
    string.append(content + "\n");
    string.append("Comments:\n");

    for (Comment comment: comments) {
      string.append(comment.getText() + "\n");
    }

    return string.toString();
  }
}
