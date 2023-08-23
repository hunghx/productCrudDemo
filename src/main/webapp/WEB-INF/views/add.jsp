<%--
  Created by IntelliJ IDEA.
  User: hung1
  Date: 8/23/2023
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới</h1>
<form action="/add" method="post" enctype="multipart/form-data">
  <input type="text" name="productName">
  <br>
  <input type="file" name="image">
  <br>
  <input type="number" name="productPrice">
  <br>
  <input type="number" name="stock">
  <br>
  <button type="submit">Add</button>
</form>
</body>
</html>
