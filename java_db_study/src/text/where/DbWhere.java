package text.where;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbWhere {
    public static void main(String[] args) {
        // データベース接続情報
        final String URL = "jdbc:mariadb://localhost/java_db"; // MAMPの場合は"localhost:8889"としてください
        final String USER_NAME = "root";
        final String PASSWORD = ""; // MAMPの場合は"root"を代入してください

        // WHERE句つきのSELECT文のフォーマット
        String sql = "SELECT * FROM users WHERE age >= ?;";

        // 検索対象となる年齢の最小値
        int minAge = 25;

        // データベース接続 ＆ SQL文の送信準備
        try (Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement statement = con.prepareStatement(sql)) {

            // SQL文の「?」部分を置き換え
            statement.setInt(1, minAge); // 年齢の最小値

            //　SQL文を実行（DBMSに送信）
            ResultSet result = statement.executeQuery();

            // SQL文の実行結果を抽出
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int age = result.getInt("age");

                System.out.println(result.getRow() + "件目：id=" + id
                        + "／name=" + name + "／age=" + age);
            }
        } catch (SQLException e) {
            System.out.println("データベース接続失敗：" + e.getMessage());
        }
    }
}