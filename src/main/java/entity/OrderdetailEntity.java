package entity;

import javax.persistence.*;

@Entity
@Table(name = "orderdetailEntity")
public class OrderdetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "productName")
    private String productName;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "ordersEntityId")
    private OrdersEntity ordersEntity;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrdersEntity getOrdersEntity() {
        return ordersEntity;
    }

    public void setOrdersEntity(OrdersEntity ordersEntity) {
        this.ordersEntity = ordersEntity;
    }


}
