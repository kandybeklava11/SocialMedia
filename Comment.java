public class Comment {
    private long id;
    private long postId;
    private long userId;
    private String text;
    private String date;

    public Comment(long id, long postId, long userId, String text, String date) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.text = text;
        this.date = date;
    }

    // Геттеры и сеттеры

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

