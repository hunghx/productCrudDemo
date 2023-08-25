<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hung1
  Date: 8/23/2023
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<a href="/add">Thêm mới</a>
<table border="10" cellspacing="10" cellpadding="20">
  <thead>
  <tr>
    <th>Code</th>
    <th>Name</th>
    <th>Image</th>
    <th>Price</th>
    <th>Stock</th>
    <th colspan="2">Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}"  var="pro">
    <tr>
      <td>${pro.code}</td>
      <td>${pro.productName}</td>
      <td><img width="100" height="100" style="object-fit: cover" src="/images/${pro.imageUrl}" alt="${pro.productName}"></td>
      <td>${pro.productPrice}</td>
      <td>${pro.stock}</td>
      <td><a href="/edit/${pro.code}">Edit</a></td>
      <td><a onclick="return confirm('Are u sure want to delete this item ?')" href="/delete/${pro.code}">Delete</a></td>
    </tr>
  </c:forEach>

  </tbody>
</table>

<div>
<%--  <img src="/images/kim-sejeong.jpg" alt="#">--%>
</div>
</body>
</html>
