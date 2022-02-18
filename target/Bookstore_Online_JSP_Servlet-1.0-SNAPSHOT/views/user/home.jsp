<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/lib/taglib.jsp" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<!-- Start Slider area -->
<div class="slider-area brown__nav slider--15 slide__activation slide__arrow01 owl-carousel owl-theme">
    <!-- Start Single Slide -->
    <div class="slide animation__style10 bg-image--8 fullscreen align__center--left">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="slider__content">
                        <div class="contentbox">
                            <h3>Boighor_</h3>
                            <h2>The Best <span>Online</span></h2>
                            <h2 class="another">book <span>shop </span></h2>
                            <p>Boighor specifically created for authors and writes to present and sell their books online Soufflé tart sweet. </p>
                            <a class="shopbtn" href="#">shop now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Single Slide -->
    <!-- Start Single Slide -->
    <div class="slide animation__style10 bg-image--9 fullscreen align__center--left">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="slider__content">
                        <div class="contentbox">
                            <h3>Boighor_</h3>
                            <h2>The Best <span>Online</span></h2>
                            <h2 class="another">book <span>shop </span></h2>
                            <p>Boighor specifically created for authors and writes to present and sell their books online Soufflé tart sweet. </p>
                            <a class="shopbtn" href="#">shop now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Single Slide -->
</div>
<!-- End Slider area -->
<!-- Start BEst Seller Area -->
<section class="wn__product__area brown--color pt--80  pb--30">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section__title text-center">
                    <h2 class="title__be--2">New <span class="color--theme">Products</span></h2>
                    <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered lebmid alteration in some ledmid form</p>
                </div>
            </div>
        </div>
        <!-- Start Single Tab Content -->
        <div class="furniture--4 border--round arrows_style owl-carousel owl-theme row mt--50">
            <c:forEach items="${requestScope.top10BookLatest}" var="book">
                <!-- Start Single Product -->
                <div class="product product__style--3">
                    <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                        <div class="product__thumb">
                            <a class="first__img" href="book-detail?isbn=${book.isbn}">
                                <img height="340px" width="270" src="<c:url value="${book.image}"/>" alt="product image">
                            </a>
                            <a class="second__img animation1" href="book-detail?isbn=${book.isbn}"><img height="340px" width="270" src="<c:url value="${book.image}"/>" alt="product image"></a>
                            <div class="hot__box">
                                <span class="hot-label">BEST SELLER</span>
                            </div>
                        </div>
                        <div class="product__content content--center">
                            <h4><a href="book-detail?isbn=${book.isbn}">${book.title}</a></h4>
                            <ul class="prize d-flex">
                                <li>$${book.price}</li>
<%--                                <li class="old_prize">$35.00</li>--%>
                            </ul>
                            <div class="action">
                                <div class="actions_inner">
                                    <ul class="add_to_links">
                                        <li><a class="cart" href="#"><i class="bi bi-shopping-bag4"></i></a></li>
                                        <li><a class="wishlist" href="#"><i class="bi bi-shopping-cart-full"></i></a></li>
                                        <li><a data-toggle="modal" title="Quick View"
                                               class="quickview modal-view detail-link" href="#productmodal"><i
                                                class="bi bi-search"></i></a></li>
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
            </c:forEach>
        </div>
        <!-- End Single Tab Content -->
    </div>
</section>
<!-- QUICKVIEW PRODUCT -->
<div id="quickview-wrapper">
    <!-- Modal -->
    <div class="modal fade" id="productmodal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal__container" role="document">
            <div class="modal-content">
                <div class="modal-header modal__header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <div class="modal-product">
                        <!-- Start product images -->
                        <div class="product-images">
                            <div class="main-image images">
                                <img alt="big images" src="images/product/big-img/1.jpg">
                            </div>
                        </div>
                        <!-- end product images -->
                        <div class="product-info">
                            <h1>Simple Fabric Bags</h1>
                            <div class="rating__and__review">
                                <ul class="rating">
                                    <li><span class="ti-star"></span></li>
                                    <li><span class="ti-star"></span></li>
                                    <li><span class="ti-star"></span></li>
                                    <li><span class="ti-star"></span></li>
                                    <li><span class="ti-star"></span></li>
                                </ul>
                                <div class="review">
                                    <a href="#">4 customer reviews</a>
                                </div>
                            </div>
                            <div class="price-box-3">
                                <div class="s-price-box">
                                    <span class="new-price">$17.20</span>
                                    <span class="old-price">$45.00</span>
                                </div>
                            </div>
                            <div class="quick-desc">
                                Designed for simplicity and made from high quality materials. Its sleek geometry and material combinations creates a modern look.
                            </div>
                            <div class="select__color">
                                <h2>Select color</h2>
                                <ul class="color__list">
                                    <li class="red"><a title="Red" href="#">Red</a></li>
                                    <li class="gold"><a title="Gold" href="#">Gold</a></li>
                                    <li class="orange"><a title="Orange" href="#">Orange</a></li>
                                    <li class="orange"><a title="Orange" href="#">Orange</a></li>
                                </ul>
                            </div>
                            <div class="select__size">
                                <h2>Select size</h2>
                                <ul class="color__list">
                                    <li class="l__size"><a title="L" href="#">L</a></li>
                                    <li class="m__size"><a title="M" href="#">M</a></li>
                                    <li class="s__size"><a title="S" href="#">S</a></li>
                                    <li class="xl__size"><a title="XL" href="#">XL</a></li>
                                    <li class="xxl__size"><a title="XXL" href="#">XXL</a></li>
                                </ul>
                            </div>
                            <div class="social-sharing">
                                <div class="widget widget_socialsharing_widget">
                                    <h3 class="widget-title-modal">Share this product</h3>
                                    <ul class="social__net social__net--2 d-flex justify-content-start">
                                        <li class="facebook"><a href="#" class="rss social-icon"><i class="zmdi zmdi-rss"></i></a></li>
                                        <li class="linkedin"><a href="#" class="linkedin social-icon"><i class="zmdi zmdi-linkedin"></i></a></li>
                                        <li class="pinterest"><a href="#" class="pinterest social-icon"><i class="zmdi zmdi-pinterest"></i></a></li>
                                        <li class="tumblr"><a href="#" class="tumblr social-icon"><i class="zmdi zmdi-tumblr"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="addtocart-btn">
                                <a href="#">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- END QUICKVIEW PRODUCT -->
<!-- Start BEst Seller Area -->
<!-- Start Testimonial Area -->
<section class="wn__testimonial__area bg--gray ptb--80">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-12">
                <div class="testimonial__container text-center">
                    <div class="tes__img__slide thumb_active ml-md-5">
                        <div class="testimonial__img">
                            <span><img src="<c:url value="/templates/user/images/testimonial/me.jpeg"/>" alt="testimonial image"></span>
                        </div>
                    </div>
                    <div class="testimonial__text__slide testext_active">
                        <div class="clint__info">
                            <p>absolutely outstanding. When I needed them they came through in a big way! I know that if you buy this theme, you'll get the one thing we all look for when we buy on.</p>
                            <div class="name__post">
                                <span>Quốc Nguyên</span>
                                <h6>Head Of Project</h6>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- End Testimonial Area -->
<!-- Start Best Seller Area -->
<section class="wn__bestseller__area bg--white pt--80  pb--30">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section__title text-center">
                    <h2 class="title__be--2">All <span class="color--theme">Products</span></h2>
                    <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered lebmid alteration in some ledmid form</p>
                </div>
            </div>
        </div>
        <div class="row mt--50">
            <div class="col-md-12 col-lg-12 col-sm-12">
                <div class="product__nav nav justify-content-center" role="tablist">
                    <a class="nav-item nav-link active" data-toggle="tab" href="#" role="tab">SEE ALL</a>
                </div>
            </div>
        </div>
        <div class="tab__container mt--60">
            <!-- Start Single Tab Content -->
            <div class="row single__tab tab-pane fade show active" id="nav-all" role="tabpanel">
                <div class="product__indicator--4 arrows_style owl-carousel owl-theme">
                    <c:forEach  var="i" begin="0" end="8" step="2">
                        <div class="single__product">
                            <!-- Start Single Product -->
                            <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                <div class="product product__style--3">
                                    <div class="product__thumb">
                                        <a class="first__img" href="book-detail?isbn=${requestScope.top10BookLatest.get(i).isbn}">
                                            <img width="270px" height="340px" src="<c:url value="${requestScope.top10BookLatest.get(i).image}"/>"
                                                 alt="product image"></a>
                                        <a class="second__img animation1" href="book-detail?isbn=${requestScope.top10BookLatest.get(i).isbn}">
                                            <img width="270px" height="340px" src="<c:url value="${requestScope.top10BookLatest.get(i).image}"/>"
                                                 alt="product image"></a>
                                        <div class="hot__box">
                                            <span class="hot-label">BEST SELLER</span>
                                        </div>
                                    </div>
                                    <div class="product__content content--center content--center">
                                        <h4><a href="book-detail?isbn=${requestScope.top10BookLatest.get(i).isbn}">
                                            ${requestScope.top10BookLatest.get(i).title}
                                        </a></h4>
                                        <ul class="prize d-flex">
                                            <li>$${requestScope.top10BookLatest.get(i).price}</li>
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
                            <!-- Start Single Product -->
                            <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                <div class="product product__style--3">
                                    <div class="product__thumb">
                                        <a class="first__img" href="book-detail?isbn=${requestScope.top10BookLatest.get(i+1).isbn}"><img width="270px" height="340px" src="<c:url value="${requestScope.top10BookLatest.get(i+1).image}"/>" alt="product image"></a>
                                        <a class="second__img animation1" href="book-detail?isbn=${requestScope.top10BookLatest.get(i+1).isbn}"><img width="270px" height="340px" src="<c:url value="${requestScope.top10BookLatest.get(i+1).image}"/>" alt="product image"></a>
                                        <div class="hot__box">
                                            <span class="hot-label">BEST SELLER</span>
                                        </div>
                                    </div>
                                    <div class="product__content content--center content--center">
                                        <h4><a href="book-detail?isbn=${requestScope.top10BookLatest.get(i+1).isbn}">${requestScope.top10BookLatest.get(i+1).title}</a></h4>
                                        <ul class="prize d-flex">
                                            <li>$${requestScope.top10BookLatest.get(i+1).price}</li>
<%--                                            <li class="old_prize">$35.00</li>--%>
                                        </ul>
                                        <div class="action">
                                            <div class="actions_inner">
                                                <ul class="add_to_links">
                                                    <li><a class="cart" href="cart.html"><i class="bi bi-shopping-bag4"></i></a></li>
                                                    <li><a class="wishlist" href="wishlist.html"><i class="bi bi-shopping-cart-full"></i></a></li>
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
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Start BEst Seller Area -->
</body>
</html>
