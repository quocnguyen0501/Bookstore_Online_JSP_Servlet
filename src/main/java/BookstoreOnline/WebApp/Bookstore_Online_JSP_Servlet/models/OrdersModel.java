package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

import java.util.List;

public class OrdersModel {
    private long id;
    private long userId;
    private long discountId;
    private long shipper;
    private String state;
    private UserModel userModel;
    private List<ItemModel> items;

    public OrdersModel() {
    }

    public OrdersModel(int id, UserModel userModel, List<ItemModel> items) {
        this.id = id;
        this.userModel = userModel;
        this.items = items;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }

    public OrdersModel(long id, long userId, long discountId, long shipper, String state) {
        this.id = id;
        this.userId = userId;
        this.discountId = discountId;
        this.shipper = shipper;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(long discountId) {
        this.discountId = discountId;
    }

    public long getShipper() {
        return shipper;
    }

    public void setShipper(long shipper) {
        this.shipper = shipper;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrdersModel{" +
                "id=" + id +
                ", userId=" + userId +
                ", discountId=" + discountId +
                ", shipper=" + shipper +
                ", state='" + state + '\'' +
                '}';
    }

    public long getTotalPrice() {
        long totalPrice = 0;
        for (ItemModel item : this.items) {
            totalPrice += item.getBookModel().getPrice() * item.getQuantity();
        }
        return totalPrice;
    }
}
