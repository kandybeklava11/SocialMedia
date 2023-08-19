import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

                // Создание объекта базы данных
                Database database = new Database();

                // Создание и сохранение пользователя
                User user = new User(1L, "Sultan", "Sultan@example.com", "password123");
                database.saveUser(user);

                // Поиск пользователя по идентификатору
                User foundUser = database.findUserById(1L);
                System.out.println("Found user: " + foundUser.getUsername());

                // Создание и сохранение профиля пользователя
                Profile profile = new Profile(1L, "John Doe", "1990-05-15", "Male", "Hello, I'm Sultan!");
                database.saveProfile(1L, profile);
                // Поиск профиля пользователя по идентификатору
                Profile foundProfile = database.findProfileByUserId(1L);
                System.out.println("Found profile: " + foundProfile.getFullName());

                // Создание и сохранение поста
                Post post = new Post(1L, 1L, "\uD83E\uDD8C", """
                        User's Post:
                        recently my friends and I went to the mountains,
                        at first we ate well, we played, there was a dense forest in the mountains and we wanted to go there,
                        everything was fine until I saw a deer, at first I was a little in a panic,
                        but then I realized that the deer did not want to harm us
                        and we just stroked and he left it was an indescribable feeling""", "2023-08-17");
                database.savePost(1L, post);
        System.out.println();


                // Создание и сохранение комментария
                Comment comment1 = new Comment(1L, 1L, 1L, "comment: cool, I also want to meet a deer","2023-08-15");
                Comment comment2 = new Comment(2L, 1L, 1L, "comment: in some cases it can be dangerous", "2023-08-16");
                Comment comment3 = new Comment(3L, 1L, 1L, "comment: \uD83D\uDD25", "2023-08-17");
                database.saveComment(1L, 1L, comment1);
                database.saveComment(1L, 1L, comment2);
                database.saveComment(1L, 1L, comment3);


                // Поиск комментариев по идентификатору поста
                Comment[] comments = post.findCommentsByPostId(database);
                System.out.println("Post comments:");
                for (Comment postComment : comments) {
                    System.out.println(postComment.getText());
                }
        System.out.println();

                // Удаление комментария
                Comment commentToDelete = comments[1];
                database.deleteComment(commentToDelete);

                // Поиск комментариев поста после удаления
                Comment[] updatedComments = post.findCommentsByPostId(database);
                System.out.println("Updated post comments:");
                for (Comment postComment : updatedComments) {
                    System.out.println(postComment.getText());
                }

                // Удаление пользователя
                database.deleteUser(0L);
            }

        }

