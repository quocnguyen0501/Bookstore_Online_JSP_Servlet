package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

import java.sql.Timestamp;

public class UserDiscountsModel {
    private long userId;
    private long discountId;

    public UserDiscountsModel() {
    }

    public UserDiscountsModel(long userId, long discountId) {
        this.userId = userId;
        this.discountId = discountId;
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

    @Override
    public String toString() {
        return "UserDiscountsModel{" +
                "userId=" + userId +
                ", discountId=" + discountId +
                '}';
    }
}
