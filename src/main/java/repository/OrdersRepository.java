package repository;

import entity.OrdersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<OrdersEntity, Integer> {
    @Query(value = "SELECT * FROM jpa_join.orderdetailentity od join jpa_join.ordersentity o on od.ordersEntityId = o.id where o.id = ?1" ,nativeQuery = true)
    List<OrdersEntity> findId (int id);
    @Query(value = "SELECT * FROM jpa_join.orderdetailentity od join jpa_join.ordersentity o on od.ordersEntityId = o.id where MONTH(orderDate)=MONTH(now());", nativeQuery = true)
    List<OrdersEntity> findByCurrentMonth();
    @Query(value = "SELECT o.*, sum(price) as sum FROM jpa_join.orderdetailentity od join jpa_join.ordersentity o on od.ordersEntityId = o.id \n" +
            "group by od.ordersEntityId\n" +
            "having sum >=?1" , nativeQuery = true)
    List<OrdersEntity> sumPrice(double price);
    @Query(value = "SELECT * FROM jpa_join.orderdetailentity od join jpa_join.ordersentity o on od.ordersEntityId = o.id \n" +
            "where od.productName = ?1" , nativeQuery = true)
    List<OrdersEntity> findProduct(String name );
}
