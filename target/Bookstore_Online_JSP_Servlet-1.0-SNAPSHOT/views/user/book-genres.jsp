<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/lib/taglib.jsp" %>

<html>
<head>
    <title>Genres</title>
</head>
<body>
<div class="pt-5 p-5 mt-5">
  <table class="table table-bordered">
    <thead>
    <tr>
      <th scope="col">STT</th>
      <th scope="col">Genres</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.genresModelList}" var="item">
      <tr>
        <th scope="row">${item.id}</th>
        <td>${item.name}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
