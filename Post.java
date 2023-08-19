public class Post {
    private long id;
    private long userId;
    private String image;
    private String description;
    private String date;

    public Post(long id, long userId, String image, String description, String date) {
        this.id = id;
        this.userId = userId;
        this.image = image;
        this.description = description;
        this.date = date;
    }

    public Comment[] findCommentsByPostId(Database database) {
        return database.getCommentsByPostId(id);
    }

    // Геттеры и сеттеры

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

