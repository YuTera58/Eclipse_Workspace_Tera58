package text.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDelete {
    public static void main(String[] args) {
        // データベース接続情報
        final String URL = "jdbc:mariadb://localhost/java_db"; // MAMPの場合は"localhost:8889"としてください
        final String USER_NAME = "root";
        final String PASSWORD = ""; // MAMPの場合は"root"を代入してください

        // DELETE文のフォーマット
        String sql = "DELETE FROM users WHERE id = ?;";

        // 削除対象のID（今回は固定データを渡す）
        int targetId = 6; // 実際に削除したいデータのIDに置き換えてください

        // データベース接続 ＆ SQL文の送信準備
        try (Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement statement = con.prepareStatement(sql)) {

            // SQL文の「?」部分を置き換え
            statement.setInt(1, targetId); // ID

            //　SQL文を実行（DBMSに送信）
            System.out.println("レコード削除:" + statement.toString());
            int rowCnt = statement.executeUpdate();
            System.out.println(rowCnt + "件のレコードが削除されました");
        } catch (SQLException e) {
            System.out.println("データベース接続失敗：" + e.getMessage());
        }
    }
}