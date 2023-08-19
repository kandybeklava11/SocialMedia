import java.util.Arrays;

public class Database {
    private User[] users;
    private Profile[] profiles;
    private Post[] posts;
    private Comment[] comments;
    private int userCount;
    private int profileCount;
    private int postCount;
    private int commentCount;

    public Database() {
        users = new User[100];
        profiles = new Profile[100];
        posts = new Post[100];
        comments = new Comment[100];
        userCount = 0;
        profileCount = 0;
        postCount = 0;
        commentCount = 0;
    }

    public void saveUser(User user) {
        users[userCount] = user;
        userCount++;
    }

    public User findUserById(long userId) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getId() == userId) {
                return users[i];
            }
        }
        return null;
    }

    public void saveProfile(long userId, Profile profile) {
        profiles[profileCount] = profile;
        profileCount++;
    }

    public Profile findProfileByUserId(long userId) {
        for (int i = 0; i < profileCount; i++) {
            if (profiles[i].getId() == userId) {
                return profiles[i];
            }
        }
        return null;
    }

    public void savePost(long userId, Post post) {
        if(userId == post.getId()) {
            System.out.println(post.getDescription());
        }
    }

    public Comment[] getCommentsByPostId(long postId) {
        Comment[] postComments = new Comment[100];
        int count = 0;
        for (int i = 0; i < commentCount; i++) {
            if (comments[i].getPostId() == postId) {
                postComments[count] = comments[i];
                count++;
            }
        }
        return Arrays.copyOf(postComments, count);
    }

    public void saveComment(long postId, long userId, Comment comment) {
        comments[commentCount] = comment;
        commentCount++;
    }

    public void deleteComment(Comment comment) {
        for (int i = 0; i < commentCount; i++) {
            if (comments[i].getId() == comment.getId()) {
                for (int j = i; j < commentCount - 1; j++) {
                    comments[j] = comments[j + 1];
                }
                comments[commentCount - 1] = null;
                commentCount--;
                break;
            }
        }
    }

    public void deleteUser(long userId) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getId() == userId) {
                for (int j = i; j < userCount - 1; j++) {
                    users[j] = users[j + 1];
                }
                users[userCount - 1] = null;
                userCount--;
                profileCount = 0; // Сброс счетчика профилей при удалении пользователя
                break;
            }
        }
//        public void deleteProfileByUserId(long userId) {
//            for (int i = 0; i < profiles.length; i++) {
//                if (profiles[i] != null && profiles[i].getId() == userId) {
//                    profiles[i] = null;
//                    break;
//                }
//            }
//        }
    }
}