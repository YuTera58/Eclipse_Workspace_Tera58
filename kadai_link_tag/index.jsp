<%-- コンテンツタイプを指定 --%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <title>kadai_link_tag</title>
    </head>
    <body>
        <%-- リンクのクリック時にServletへデータを渡す(GETメソッド) --%>
        <a href="<%= request.getContextPath() %>/link?name=侍太郎">名前「侍太郎」をServletに送信</a>
        
        <%-- リンクのクリック時にServletからデータを受信 --%>
        <%-- EL式でリクエストスコープのデータを取得 --%>
        <h3>${userName}</h3>
    </body>
</html>