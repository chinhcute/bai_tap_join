package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "orderDate")
    private LocalDate orderDate;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "customerAddress")
    private String customerAddress;
}
