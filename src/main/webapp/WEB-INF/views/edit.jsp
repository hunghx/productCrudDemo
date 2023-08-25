<%--
  Created by IntelliJ IDEA.
  User: hung1
  Date: 8/25/2023
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chỉnh sửa</h1>
<form action="/update" method="post" enctype="multipart/form-data">
  <input type="text" value="${productEdit.code}" name="code" readonly>
  <input type="text" value="${productEdit.productName}" name="productName">
  <br>
  <input type="file"  name="image">
  <div>
    <img width="100px" src="/images/${productEdit.imageUrl}" alt="#">
  </div>
  <br>
  <input type="number" value="${productEdit.productPrice}" name="productPrice">
  <br>
  <input type="number" value="${productEdit.stock}" name="stock">
  <br>
  <button type="submit">Update</button>
</form>
</body>
</html>
