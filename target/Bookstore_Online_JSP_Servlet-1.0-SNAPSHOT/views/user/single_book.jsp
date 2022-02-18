<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/lib/taglib.jsp" %>

<html>
<head>
    <title>Book Detail</title>
</head>
<body>
<!-- Start main Content -->
<div class="maincontent bg--white pt--80 pb--55">
    <div class="container">
        <div class="row">
            <div class="col-lg-9 col-12">
                <div class="wn__single__product">
                    <div class="row">
                        <div class="col-lg-6 col-12">
                            <img width="420px" height="525px" src="<c:url value="${requestScope.booksModel.image}"/> "
                                 alt="${requestScope.booksModel.title}">
                        </div>
                        <div class="col-lg-6 col-12">
                            <form class="product__info__main" action="<c:url value="/cart?isbn=${requestScope.booksModel.isbn}"/>" method="post">
                                <h1>${requestScope.booksModel.title}</h1>
                                <div class="price-box">
                                    <span>$${requestScope.booksModel.price}</span>
                                </div>
                                <div class="product__overview">
                                    <strong>GENRES : </strong>
                                    <ul class="pro__attribute">
                                        <li>
                                            <ul>
                                                <c:forEach items="${requestScope.genres}" var="item">
                                                    <li>- ${item}</li>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                        <li><strong>ISBN: </strong>  ${requestScope.booksModel.isbn}</li>
                                        <li><strong>PUBLICATION DATE:</strong>   ${requestScope.booksModel.publicationDate}</li>
                                        <li><strong>EDITION:</strong>    ${requestScope.booksModel.edition}</li>
                                        <li><strong>AVAILABLE QUANTITY: </strong>    ${requestScope.booksModel.availableQuantity}</li>
                                    </ul>
                                </div>
                                <div class="box-tocart d-flex">
                                    <span>Quantity</span>
                                    <input id="qty" class="input-text qty" name="quantity" min="1" value="1" title="Qty" type="number">
                                    <div class="addtocart__actions">
                                        <button class="tocart" type="submit" title="Add to Cart">Add to Cart</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="wn__related__product pt--80 pb--50">
                    <div class="section__title text-center">
                        <h2 class="title__be--2">Similar Books</h2>
                    </div>
                    <div class="row mt--60">
                        <div class="productcategory__slide--2 arrows_style owl-carousel owl-theme">
                            <c:forEach items="${requestScope.similarBooks}" var="book">
                                <!-- Start Single Product -->
                                <div class="single__product">
                                    <!-- Start Single Product -->
                                    <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                        <div class="product product__style--3">
                                            <div class="product__thumb">
                                                <a class="first__img" href="book-detail?isbn=${book.isbn}">
                                                    <img width="270px" height="340px" src="<c:url value="${book.image}"/>"
                                                         alt="product image"></a>
                                                <a class="second__img animation1" href="book-detail?isbn=${book.isbn}">
                                                    <img width="270px" height="340px" src="<c:url value="${book.image}"/>"
                                                         alt="product image"></a>
                                                <div class="hot__box">
                                                    <span class="hot-label">BEST SELLER</span>
                                                </div>
                                            </div>
                                            <div class="product__content content--center content--center">
                                                <h4><a href="book-detail?isbn=${book.isbn}">
                                                        ${book.title}
                                                </a></h4>
                                                <ul class="prize d-flex">
                                                    <li>$${book.price}</li>
                                                        <%--                                            <li class="old_prize">$35.00</li>--%>
                                                </ul>
                                                <div class="action">
                                                    <div class="actions_inner">
                                                        <ul class="add_to_links">
                                                            <li><a class="cart" href="#"><i class="bi bi-shopping-bag4"></i></a></li>
                                                            <li><a class="wishlist" href="#"><i class="bi bi-shopping-cart-full"></i></a></li>
                                                            <li><a data-toggle="modal" title="Quick View" class="quickview modal-view detail-link" href="#productmodal"><i class="bi bi-search"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="product__hover--content">
                                                    <ul class="rating d-flex">
                                                        <li class="on"><i class="fa fa-star-o"></i></li>
                                                        <li class="on"><i class="fa fa-star-o"></i></li>
                                                        <li class="on"><i class="fa fa-star-o"></i></li>
                                                        <li><i class="fa fa-star-o"></i></li>
                                                        <li><i class="fa fa-star-o"></i></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Start Single Product -->
                                </div>
                                <!-- Start Single Product -->
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End main Content -->
</body>
</html>
