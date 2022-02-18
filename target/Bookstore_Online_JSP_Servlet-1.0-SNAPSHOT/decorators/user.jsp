<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/lib/taglib.jsp" %>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title><dec:title default="Home Page"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Favicons -->
    <link rel="shortcut icon" href="<c:url value="/templates/user/images/favicon.ico"/>">
    <link rel="apple-touch-icon" href="<c:url value="/templates/user/images/icon.png"/>">

    <!-- Google font (font-family: 'Roboto', sans-serif; Poppins ; Satisfy) -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,500,600,600i,700,700i,800" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" rel="stylesheet">

    <!-- Stylesheets -->
    <link rel="stylesheet" href="<c:url value="/templates/user/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/templates/user/css/plugins.css"/>">
    <link rel="stylesheet" href="<c:url value="/templates/user/style.css"/>">

    <!-- Custom css -->
    <link rel="stylesheet" href="<c:url value="/templates/user/css/custom.css"/>">

    <!-- Modernizer js -->
    <script src="<c:url value="/templates/user/js/vendor/modernizr-3.5.0.min.js"/>"></script>

    <%--  Box icon  --%>
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<!-- Main wrapper -->
<div class="wrapper" id="wrapper">
<%-- Header --%>
    <%@include file="/common/user/header.jsp" %>
<%-- End Header --%>
<%-- Search popup --%>
    <%@include file="/common/user/search_popup.jsp"%>
<%--  End Search Popup  --%>
<%--  Content  --%>
    <dec:body/>
<%--  End Content  --%>
<%--  Footer  --%>
    <%@include file="/common/user/footer.jsp"%>
<%--  End Footer  --%>
</div>
<!-- //Main wrapper -->

<!-- JS Files -->
<script src="<c:url value="/templates/user/js/vendor/jquery-3.2.1.min.js"/>"></script>
<script src="<c:url value="/templates/user/js/popper.min.js"/>"></script>
<script src="<c:url value="/templates/user/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/templates/user/js/plugins.js"/>"></script>
<script src="<c:url value="/templates/user/js/active.js"/>"></script>

</body>
</html>