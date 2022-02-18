<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/lib/taglib.jsp" %>

<html>
<head>
  <title>Products</title>
</head>
<body>
<!-- Start Shop Page -->
<div class="page-shop-sidebar left--sidebar bg--white section-padding--lg">
  <div class="container">
    <div class="row">
      <div class="col-lg-3 col-12 order-2 order-lg-1 md-mt-40 sm-mt-40">
        <div class="shop__sidebar">
          <aside class="wedget__categories poroduct--cat">
            <h3 class="wedget__title justify-content-between">
              <a href="#">Totals Books<span>(${requestScope.totalBooks})</span></a>
            </h3>
          </aside>
          <aside class="wedget__categories poroduct--cat">
            <h3 class="wedget__title">Product Categories</h3>
            <ul>
              <c:forEach items="${requestScope.genres}" var="item">
                <li><a href="#">${item}</li>
              </c:forEach>
            </ul>
          </aside>
          <aside class="wedget__categories pro--range">
            <h3 class="wedget__title">Filter by price</h3>
            <div class="content-shopby">
              <div class="price_filter s-filter clear">
                <form action="#" method="GET">
                  <div id="slider-range"></div>
                  <div class="slider__range--output">
                    <div class="price__output--wrap">
                      <div class="price--output">
                        <span>Price :</span><input type="text" id="amount" readonly="">
                      </div>
                      <div class="price--filter">
                        <a href="#">Filter</a>
                      </div>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </aside>
        </div>
      </div>
      <div class="col-lg-9 col-12 order-1 order-lg-2">
        <div class="row">
          <div class="col-lg-12">
            <div class="shop__list__wrapper d-flex flex-wrap flex-md-nowrap justify-content-between">
              <div class="shop__list nav justify-content-center" role="tablist">
                <a class="nav-item nav-link active" data-toggle="tab" href="#nav-grid" role="tab"><i class="fa fa-th"></i></a>
                <a class="nav-item nav-link" data-toggle="tab" href="#nav-list" role="tab"><i class="fa fa-list"></i></a>
              </div>
              <p>Showing 1–12 of 40 results</p>
              <div class="orderby__wrapper">
                <span>Sort By</span>
                <select class="shot__byselect">
                  <option><a href="#">Price</a></option>
                  <option><a href="#">Publication Date</a></option>
                </select>
              </div>
            </div>
          </div>
        </div>
        <div class="tab__container">
          <div class="shop-grid tab-pane fade show active" id="nav-grid" role="tabpanel">
            <div class="row">
              <c:forEach items="${requestScope.allBooks}" var="book">
                <!-- Start Single Product -->
                <div class="col-lg-4 col-md-4 col-sm-6 col-12">
                  <div class="product">
                    <div class="product__thumb">
                      <a class="first__img" href="book-detail?isbn=${book.isbn}"><img height="450px" width="450px" src="<c:url value="${book.image}"/>" alt="product image"></a>
                      <a class="second__img animation1" href="book-detail?isbn=${book.isbn}"><img height="450px" width="450px" src="<c:url value="${book.image}"/>" alt="product image"></a>
                      <div class="new__box">
                        <span class="new-label">Hot</span>
                      </div>
                      <ul class="prize position__right__bottom d-flex">
                        <li>$${book.price}</li>
<%--                        <li class="old_prize">$55.00</li>--%>
                      </ul>
                      <div class="action">
                        <div class="actions_inner">
                          <ul class="add_to_links">
                            <li><a class="cart" href="book-detail?isbn=${book.isbn}"></a></li>
                            <li><a class="wishlist" href="#"></a></li>
                            <li><a class="compare" href="#"></a></li>
                            <li><a data-toggle="modal" title="Quick View" class="quickview modal-view detail-link" href="#productmodal"></a></li>
                          </ul>
                        </div>
                      </div>
                    </div>
                    <div class="product__content">
                      <h4><a href="book-detail?isbn=${book.isbn}">${book.title}</a></h4>
                    </div>
                  </div>
                </div>
                <!-- End Single Product -->
              </c:forEach>
            </div>
            <button onclick="loadMore()" class="btn btn-primary">Load more</button>
          </div>
          <div class="shop-grid tab-pane fade" id="nav-list" role="tabpanel">
            <div class="list__view__wrapper pb-5">
              <c:forEach items="${requestScope.allBooks}" var="book">
                <!-- Start Single Product -->
                <div class="list__view">
                  <div class="thumb">
                    <a class="first__img" href="book-detail?isbn=${book.isbn}"><img src="<c:url value="${book.image}"/>" alt="product images"></a>
                    <a class="second__img animation1" href="book-detail?isbn=${book.isbn}"><img src="<c:url value="${book.image}"/>" alt="product images"></a>
                  </div>
                  <div class="content">
                    <h2><a href="book-detail?isbn=${book.isbn}">${book.title}</a></h2>
                    <ul class="rating d-flex">
                      <li class="on"><i class="fa fa-star-o"></i></li>
                      <li class="on"><i class="fa fa-star-o"></i></li>
                      <li class="on"><i class="fa fa-star-o"></i></li>
                      <li class="on"><i class="fa fa-star-o"></i></li>
                      <li><i class="fa fa-star-o"></i></li>
                      <li><i class="fa fa-star-o"></i></li>
                    </ul>
                    <ul class="prize__box">
                      <li>$${book.price}</li>
<%--                      <li class="old__prize">$220.00</li>--%>
                    </ul>
                    <ul class="cart__action d-flex">
                      <li class="cart"><a href="cart?isbn=${book.isbn}">Add to cart</a></li>
                    </ul>
                  </div>
                </div>
                <!-- End Single Product -->
              </c:forEach>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>