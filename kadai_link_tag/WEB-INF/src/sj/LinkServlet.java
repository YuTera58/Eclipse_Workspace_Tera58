package sj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet
{
	// GETメソッドのリクエスト受信時に実行されるメソッド
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // リクエスト・レスポンスの設定
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        // JSPからのリクエストデータ取得
        String userName = request.getParameter("name");
        
        // リクエストスコープにデータを保存
        request.setAttribute( "userName", "Servletからデータを受信しました:　" + userName + "さん、こんにちは！" );
        // RequestDispatcherインターフェースで画面遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        // フォワードによる画面遷移
        dispatcher.forward(request, response);
    }
}
