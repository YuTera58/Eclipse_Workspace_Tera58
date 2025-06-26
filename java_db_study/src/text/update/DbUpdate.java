package text.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbUpdate {
    public static void main(String[] args) {
        // データベース接続情報
        final String URL = "jdbc:mariadb://localhost/java_db"; // MAMPの場合は"localhost:8889"としてください
        final String USER_NAME = "root";
        final String PASSWORD = ""; // MAMPの場合は"root"を代入してください

        // UPDATE文のフォーマット
        String sql = "UPDATE users SET name = ? WHERE id = ?;";

        // 新しい氏名
        String newName = "武士山花子";
        // 更新対象のID（今回は固定データを渡す）
        int targetId = 2;

        // データベース接続 ＆ SQL文の送信準備
        try (Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement statement = con.prepareStatement(sql)) {

            // SQL文の「?」部分を置き換え
            statement.setString(1, newName); // 氏名
            statement.setInt(2, targetId); // ID

            //　SQL文を実行（DBMSに送信）
            System.out.println("レコード更新:" + statement.toString());
            int rowCnt = statement.executeUpdate();
            System.out.println(rowCnt + "件のレコードが更新されました");
        } catch (SQLException e) {
            System.out.println("データベース接続失敗：" + e.getMessage());
        }
    }
}