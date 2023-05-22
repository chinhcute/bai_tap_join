package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
    @Table(name = "ordersEntity")
    public class OrdersEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
        @Column(name = "orderDate")
        private LocalDate orderDate;
        @Column(name = "customerName")
        private String customerName;
    @OneToMany(mappedBy = "ordersEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderdetailEntity> orderdetailEntities;

    @Override
    public String toString() {
        return "OrdersEntity{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", customerName='" + customerName + '\'' +
                ", orderdetailEntities=" + orderdetailEntities +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderdetailEntity> getOrderdetailEntities() {
        return orderdetailEntities;
    }

    public void setOrderdetailEntities(List<OrderdetailEntity> orderdetailEntities) {
        this.orderdetailEntities = orderdetailEntities;
    }
}
