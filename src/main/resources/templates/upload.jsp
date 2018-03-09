<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html;charset=UTF-8">
        <title>upload page</title>
    </head>
    <body>
        <div class="upload">
            <form action="upload" enctype="multipart/form-data" method="post">
                <input type="file" name="file"><br/>
                <input type="submit" value="upload">
            </form>
        </div>
    </body>
</html>