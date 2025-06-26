package text.orderby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DbOrderBy {
    public static void main(String[] args) {
        // データベース接続情報
        final String URL = "jdbc:mariadb://localhost/java_db"; // MAMPの場合は"localhost:8889"としてください
        final String USER_NAME = "root";
        final String PASSWORD = ""; // MAMPの場合は"root"を代入してください

        // 並べ替え方向の決定
        String order;
        System.out.println("0(昇順)か1(降順)を入力してください：");
        try (Scanner scanner = new Scanner(System.in)) {

            // 入力内容に応じて並べ替え方向を決定
            order = (scanner.nextInt() == 1) ? "DESC;" : "ASC;";
        } catch (InputMismatchException e) {
            System.out.println("入力が正しくありません");
            return;
        }

        // ORDER BY句つきのSELECT文のフォーマット
        String sql = "SELECT * FROM users ORDER BY age " + order;
        System.out.println("レコード取得:" + sql);

        // データベース接続 ＆ SQL文の送信準備
        try (Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                Statement statement = con.createStatement()) {

            //　SQL文を実行（DBMSに送信）
            ResultSet result = statement.executeQuery(sql);

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