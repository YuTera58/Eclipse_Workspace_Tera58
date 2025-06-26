package text.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    public static void main(String[] args) {
	// データベースに接続（try-with-resources文を使用）
	try (Connection con = DriverManager.getConnection(
		"jdbc:mariadb://localhost/java_db", // MAMPの場合は"localhost:8889"としてください
		"root",
		"" // MAMPの場合は"root"を代入してください
	)) {
	    System.out.println("データベース接続成功");
	    System.out.println(con);
	} catch (SQLException e) {
	    System.out.println("データベース接続失敗：" + e.getMessage());
	}
    }
}
