<%@ page contentType="text/html; charset=UTF-8" %>

<html>

    <head>
        <title>個人情報入力フォームを作ろう</title>
    </head>
    
    <body>        
        <h2>個人情報入力フォーム</h2>
        <form action="<%= request.getContextPath() %>/confirm" method="post">
	        <table>
	            <tr>
	                <td>氏名</td>
	                <td>
                        <input type="text" name="name" value="" >
	                </td>
	            </tr>
	            <tr>
	                <td>メールアドレス</td>
	                <td>
                        <input type="text" name="email" value="" >
	                </td>
	            </tr>
	            <tr>
	                <td>住所</td>
	                <td>
	                    <input type="text" name="address" value="" >
	                </td>
	            </tr>
	            <tr>
	                <td>電話番号</td>
	                <td>
	                    <input type="text" name="phone_number" value="" >
	                </td>
	            </tr>
	        </table>
            <input type="submit" value="送信">
        </form>
    </body>
    
</html>