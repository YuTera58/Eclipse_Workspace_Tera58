<%@ page contentType="text/html; charset=UTF-8" %>

<html>

    <head>
        <title>個人情報入力フォームを作ろう</title>
    </head>
    
    <body>
        <h2>入力内容をご確認ください。</h2>
        <p>問題なければ「確定」、修正する場合は「キャンセル」をクリックしてください。</p>
        <table border="1">
            <tr>
                <th>項目</th>
                <th>入力内容</th>
            </tr>
            <tr>
                <td>指名</td>
                <td>${name}</td>
            </tr>
            <tr>
                <td>メールアドレス</td>
                <td>${email}</td>
            </tr>
            <tr>
                <td>住所</td>
                <td>${address}</td>
            </tr>
            <tr>
                <td>電話番号</td>
                <td>${phone_number}</td>
            </tr>
        </table>
        
        <p>
            <%-- 確定ボタン（登録に成功した前提で完了画面に遷移） --%>
            <button
                onclick="location.href='<%= request.getContextPath() %>/complete';">確定</button>

            <%-- キャンセルボタン（前の画面に戻る） --%>
            <button onclick="history.back();">キャンセル</button>
        </p>
    </body>
    
</html>