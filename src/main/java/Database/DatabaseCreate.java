package Database;


import java.sql.Connection;



import java.sql.Statement;

public class DatabaseCreate {


    public static void createNewTable() {
        /*String sql = "CREATE TABLE IF NOT EXISTS flashcards (\n"
                + " id INT AUTO_INCREMENT PRIMARY KEY,\n"
                + " title varchar(255) not null,\n"
                + " question text,\n"
                + " answer text\n"
                + ");";*/


        /*String sql = "CREATE TABLE IF NOT EXISTS Tags (\n"
                + " id INT AUTO_INCREMENT PRIMARY KEY,\n"
                + " title VARCHAR(255) NOT NULL\n"
                + ");";*/

        /*String sql = "CREATE TABLE IF NOT EXISTS flashcard_tags (\n"
                + " flashcard_id INT,\n"
                + " tag_id INT,\n"
                + " PRIMARY KEY (flashcard_id, tag_id),\n"
                + " FOREIGN KEY (flashcard_id) REFERENCES flashcards(id) ON DELETE CASCADE ON UPDATE CASCADE,\n"
                + " FOREIGN KEY (tag_id) REFERENCES tags(id) ON UPDATE CASCADE\n"
                + ");";*/

        /*String sql = "INSERT INTO FLASHCARD_TAGS (FLASHCARD_ID, TAG_ID) VALUES (14, 2);\n";*/

        /*String sql = "CREATE TABLE IF NOT EXISTS users_tags (\n"
                + " user_id INT,\n"
                + " tag_id INT,\n"
                + " PRIMARY KEY (user_id, tag_id),\n"
                + " FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,\n"
                + " FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE CASCADE ON UPDATE CASCADE\n"
                + ");";*/

        String sql = "CREATE TABLE IF NOT EXISTS users_flashcards (\n"
                + " user_id INT,\n"
                + " flashcard_id INT,\n"
                + " PRIMARY KEY (user_id, flashcard_id),\n"
                + " FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,\n"
                + " FOREIGN KEY (flashcard_id) REFERENCES flashcards(id) ON DELETE CASCADE ON UPDATE CASCADE\n"
                + ");";
        /*String sql = "CREATE TABLE IF NOT EXISTS password_reset_tokens (\n"
                + "email VARCHAR(255),\n"
                + "token VARCHAR(255), \n"
                + "expiry_date TIMESTAMP \n"
                + ");";*/


        /*String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
                + " id INT AUTO_INCREMENT PRIMARY KEY,\n"
                + " username VARCHAR(255) NOT NULL,\n"
                + " email VARCHAR(255) NOT NULL,\n"
                + " password VARCHAR(255) NOT NULL\n"
                + ");";*/



        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabelle in der H2-Datenbank erstellt.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public static void main(String[] args) {
        createNewTable();

    }

}
