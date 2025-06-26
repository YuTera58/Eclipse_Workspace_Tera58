package text.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSelect {
    public static void main(String[] args) {
        // データベース接続情報
        final String URL = "jdbc:mariadb://localhost/java_db"; // MAMPの場合は"localhost:8889"としてください
        final String USER_NAME = "root";
        final String PASSWORD = ""; // MAMPの場合は"root"を代入してください

        // SELECT文のフォーマット
        String sql = "SELECT id, name FROM users;";

        // データベース接続 ＆ SQL文の送信準備
        try (Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                Statement statement = con.createStatement()) {

            //　SQL文を実行（DBMSに送信）
            ResultSet result = statement.executeQuery(sql);

            // SQL文の実行結果を抽出
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");

                System.out.println(result.getRow() + "件目：id=" + id + "／name=" + name);
            }
        } catch (SQLException e) {
            System.out.println("データベース接続失敗：" + e.getMessage());
        }
    }
}
