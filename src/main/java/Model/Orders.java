package Model;

public class Orders {
    private int orderId;
    private String date;
    private int customerId;
    private String address;
    private int productId;
    private int Qty;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public Orders(int orderId, String date, int customerId, String address, int productId, int qty) {
        this.orderId = orderId;
        this.date = date;
        this.customerId = customerId;
        this.address = address;
        this.productId = productId;
        Qty = qty;
    }
}
