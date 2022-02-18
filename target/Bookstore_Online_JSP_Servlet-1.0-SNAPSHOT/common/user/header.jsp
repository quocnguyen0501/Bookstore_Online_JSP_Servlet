<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/lib/taglib.jsp" %>
<!-- Header -->
<header id="wn__header" class="header__area header__absolute sticky__header">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-6 col-sm-6 col-6 col-lg-2">
        <div class="logo">
          <a href="home-page">
            <img src="<c:url value="/templates/user/images/logo/logo.png"/>" alt="logo images">
          </a>
        </div>
      </div>
      <div class="col-lg-8 d-none d-lg-block">
        <nav class="mainmenu__nav">
          <ul class="meninmenu d-flex justify-content-start">
            <li class="drop with--one--item"><a href="home-page">Home</a></li>
            <li class="drop"><a href="books">All books</a></li>
            <li class="drop"><a href="home-page?action=cart">Books Genres</a></li>
            <li class="drop"><a href="cart">Your cart</a></li>
            <c:if test="${sessionScope.role.size() == 2}">
              <li class="drop"><a href="#">Dashboard</a></li>
            </c:if>
          </ul>
        </nav>
      </div>
      <div class="col-md-6 col-sm-6 col-6 col-lg-2">
        <ul class="header__sidebar__right d-flex justify-content-end align-items-center">
          <li class="shop_search"><a class="search__active" href="#"></a></li>
          <li class="wishlist"><a href="#"></a></li>
          <li class="shopcart">
            <a class="cartbox_active" href="cart">
              <c:if test="${sessionScope.order.items.size() > 0}">
                <span class="product_qun">${sessionScope.order.items.size()}</span>
              </c:if>
            </a>
            <c:if test="${sessionScope.order.items.size() > 0}">
              <!-- Start Shopping Cart -->
              <div class="block-minicart minicart__active">
                <div class="minicart-content-wrapper">
                  <div class="micart__close">
                    <span>close</span>
                  </div>
                  <div class="items-total d-flex justify-content-between">
                    <span>${sessionScope.order.items.size()} items</span>
                    <span>Cart Subtotal</span>
                  </div>
                  <div class="total_amount text-right">
                    <span>$${sessionScope.order.totalPrice}</span>
                  </div>
                  <div class="mini_action checkout">
                    <a class="checkout__btn" href="cart">Go to Checkout</a>
                  </div>
                  <div class="single__items">
                    <div class="miniproduct">
                      <c:forEach items="${sessionScope.order.items}" var="book">
                        <input type="text" name="action" hidden value="update">
                        <input type="text" name="isbn" hidden value="${book.bookModel.isbn}">
                        <div class="item01 d-flex">
                          <div class="thumb">
                            <a href="book-detail?isbn=${book.bookModel.isbn}"><img src="<c:url value="${book.bookModel.image}"/>" alt="product images"></a>
                          </div>
                          <div class="content">
                            <h6><a href="book-detail?isbn=${book.bookModel.isbn}">${book.bookModel.title}</a></h6>
                            <span class="prize">$${(book.quantity)*(book.bookModel.price)}</span>
                            <div class="product_prize d-flex justify-content-between">
                              <span class="qun">Quantity: ${book.quantity}</span>
                              <ul class="d-flex justify-content-end">
                                <li><button type="submit"><i class="zmdi zmdi-settings"></i></button></li>
                                <li><a href="<c:url value="/cart?action=delete&isbn=${book.bookModel.isbn}"/>"><i class="zmdi zmdi-delete"></i></a></li>
                              </ul>
                            </div>
                          </div>
                        </div>
                      </c:forEach>
                    </div>
                  </div>
                  <div class="mini_action cart">
                    <a class="cart__btn" href="cart">View and edit cart</a>
                  </div>
                </div>
              </div>
              <!-- End Shopping Cart -->
            </c:if>
          </li>
          <li class="setting__bar__icon"><a class="setting__active" href="#"></a>
            <div class="searchbar__content setting__block">
              <div class="content-inner">
                <div class="switcher-currency">
                  <c:if test="${sessionScope.user != null}">
                    <strong class="label switcher-label">
                      <span>Welcome ${sessionScope.user}</span>
                    </strong>
                    <div class="switcher-options">
                      <div class="switcher-currency-trigger">
                        <div class="setting__menu">
                          <span><a href="logout">Log out</a></span>
                        </div>
                      </div>
                    </div>
                  </c:if>
                  <c:if test="${sessionScope.user == null}">
                    <strong class="label switcher-label">
                      <span>Account</span>
                    </strong>
                    <div class="switcher-options">
                      <div class="switcher-currency-trigger">
                        <div class="setting__menu">
                          <span><a href="login">Sign In</a></span>
                          <span><a href="signup">Create An Account</a></span>
                        </div>
                      </div>
                    </div>
                  </c:if>
                </div>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <!-- Start Mobile Menu -->
    <div class="row d-none">
      <div class="col-lg-12 d-none">
        <nav class="mobilemenu__nav">
          <ul class="meninmenu">
            <li><a href="home-page">Home</a></li>
            <li><a href="books">All Books</a></li>
            <li><a href="home-page?action=cart">Book Genres</a></li>
            <li><a href="#">Your Cart</a></li>
            <li><a href="#">DashBoard</a></li>
          </ul>
        </nav>
      </div>
    </div>
    <!-- End Mobile Menu -->
    <div class="mobile-menu d-block d-lg-none">
    </div>
    <!-- Mobile Menu -->
  </div>
</header>
<!-- //Header -->