<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/lib/taglib.jsp" %>

<html>
<head>
    <title>Login - Signup</title>
</head>
<body>
<section class="signup">
    <div class="container">
        <div class="signup-content">
            <div class="signup-form">
                <h2 class="form-title">Sign up</h2>
                <c:if test="${requestScope.error != null}">
                    <div style="font-size: 15px; color: red" role="alert" align="center">
                            ${requestScope.error}
                    </div>
                </c:if>
                <form method="POST" class="register-form" id="register-form">
                    <div class="form-group">
                        <label for="full_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                        <input required type="text" name="full_name" id="full_name" placeholder="Your Name"
                               value="${requestScope.full_name != null ? requestScope.full_name : null}"/>
                    </div>
                    <div class="form-group">
                        <label for="username"><i class="zmdi zmdi-email"></i></label>
                        <input required type="text" name="username" id="username" placeholder="Your Username"
                               value="${requestScope.username != null ? requestScope.username : null}"/>
                    </div>
                    <div class="form-group">
                        <label for="password"><i class="zmdi zmdi-lock"></i></label>
                        <input required type="password" name="password" id="password" placeholder="Your Password"/>
                    </div>
                    <div class="form-group">
                        <label for="re_password"><i class="zmdi zmdi-lock-outline"></i></label>
                        <input required type="password" name="re_password" id="re_password" placeholder="Repeat your password"/>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                        <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                    </div>
                    <div class="form-group form-button">
                        <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                    </div>
                </form>
            </div>
            <div class="signup-image">
                <figure><img src="<c:url value="/templates/login-signup/images/signup-image.jpg"/>" alt="sing up image"></figure>
                <a href="login" class="signup-image-link">I am already member</a>
            </div>
        </div>
    </div>
</section>
</body>
</html>
