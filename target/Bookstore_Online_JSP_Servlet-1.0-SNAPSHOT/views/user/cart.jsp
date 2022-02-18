<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/lib/taglib.jsp" %>

<html>
<head>
    <title>Products</title>
</head>
<body>
<!-- cart-main-area start -->
<div class="cart-main-area section-padding--lg bg--white">
  <div class="container">
    <div class="row">
      <div class="col-md-12 col-sm-12 ol-lg-12">
        <form action="#">
          <div class="table-content wnro__table table-responsive">
            <table>
              <thead>
              <tr class="title-top">
                <th class="product-thumbnail">Image</th>
                <th class="product-name">Book Title</th>
                <th class="product-price">Price</th>
                <th class="product-quantity">Quantity</th>
                <th class="product-subtotal">Total</th>
                <th class="product-remove">Update</th>
                <th class="product-remove">Remove</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${sessionScope.order.items}" var="item">
                <tr>
                  <input type="text" name="action" hidden value="update">
                  <input type="text" name="isbn" hidden value="${item.bookModel.isbn}">
                  <td class="product-thumbnail"><a href="#"><img height="100px" width="80px" src="<c:url value="${item.bookModel.image}"/>" alt="product img"></a></td>
                  <td class="product-name"><a href="#">${item.bookModel.title}</a></td>
                  <td class="product-price"><span class="amount">$${item.bookModel.price}</span></td>
                  <td class="product-quantity"><input type="number" name="quantity" value="${item.quantity}"></td>
                  <td class="product-subtotal">$${(item.quantity)*(item.bookModel.price)}</td>
                  <td class="product-remove">
                    <button class="border--round" type="submit">
                      <i class='bx bxs-save'></i>
                    </button>
                  </td>
                  <td class="product-remove">
                    <a class="border--round justify-content-center" href="<c:url value="/cart?action=delete&isbn=${item.bookModel.isbn}"/>">
                      <i class='bx bx-trash'></i>
                    </a>
                  </td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </form>
        <div class="cartbox__btn">
          <ul class="cart__btn__list d-flex flex-wrap flex-md-nowrap flex-lg-nowrap justify-content-between">
            <li><a href="#">Coupon Code</a></li>
            <li><a href="#">Apply Code</a></li>
            <li><a href="#">Update Cart</a></li>
            <li><a href="#">Check Out</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-6 offset-lg-6">
        <div class="cartbox__total__area">
          <div class="cartbox-total d-flex justify-content-between">
            <ul class="cart__total__list">
              <li>Cart total</li>
              <li>Sub Total</li>
            </ul>
            <ul class="cart__total__tk">
              <li>$${sessionScope.order.totalPrice}</li>
              <li>$0</li>
            </ul>
          </div>
          <div class="cart__total__amount">
            <span>Grand Total</span>
            <span>$${sessionScope.order.totalPrice}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- cart-main-area end -->
</body>
</html>
