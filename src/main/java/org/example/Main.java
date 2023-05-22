package org.example;

import confi.JPA_config;
import entity.OrderdetailEntity;
import entity.OrdersEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.OrdersRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPA_config.class);
    static OrdersRepository ordersRepository = (OrdersRepository) context.getBean("ordersRepository");
    public static void main(String[] args) {
//        saveOrder();
//        nhap();
//        findAll();
//        findById(2);
//        findByCurrentMonth();
        sumPrice(390.000);
//        findProduct("java");
    }

    public  static void saveOrder(){
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setOrderDate(LocalDate.now());
        ordersEntity.setCustomerName("chinh");

        OrderdetailEntity orderdetailEntity = new OrderdetailEntity();
        orderdetailEntity.setPrice(100.000);
        orderdetailEntity.setProductName("sachs");

        orderdetailEntity.setQuantity(2);
        orderdetailEntity.setOrdersEntity(ordersEntity);
        List<OrderdetailEntity> orderDetails = new ArrayList<>();

        orderDetails.add(orderdetailEntity);
        ordersEntity.setOrderdetailEntities(orderDetails);
        ordersRepository.save(ordersEntity);

    }
    public static void nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập OrderDate");
        LocalDate OrderDate = LocalDate.parse(scanner.next());
        System.out.println("nhập CustomerName");
        String CustomerName = scanner.next();


        System.out.println("nhập Price");
        double price = scanner.nextDouble();
        System.out.println("nhập ProductName");
        String ProductName = scanner.next();
        System.out.println("nhập Quantity");
        int Quantity = scanner.nextInt();

        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setOrderDate(OrderDate);
        ordersEntity.setCustomerName(CustomerName);

        OrderdetailEntity orderdetailEntity = new OrderdetailEntity();
        orderdetailEntity.setPrice(price);
        orderdetailEntity.setProductName(ProductName);
        orderdetailEntity.setQuantity(Quantity);

        orderdetailEntity.setOrdersEntity(ordersEntity);
        List<OrderdetailEntity> orderDetails = new ArrayList<>();
        orderDetails.add(orderdetailEntity);
        ordersEntity.setOrderdetailEntities(orderDetails);
        ordersRepository.save(ordersEntity);
    }
    public static void findAll() {
        List<OrdersEntity> ordersEntities = (List<OrdersEntity>) ordersRepository.findAll();
        for (OrdersEntity ordersEntity : ordersEntities) {
            System.out.println(ordersEntity.toString());
            List<OrderdetailEntity> orderdetailEntities = ordersEntity.getOrderdetailEntities();
            for (OrderdetailEntity orderdetailEntity : orderdetailEntities) {
                System.out.println(orderdetailEntity.getProductName() + "," + orderdetailEntity.getQuantity() + "," + orderdetailEntity.getPrice());
            }
        }
    }
    public static void findById(int id){
        List<OrdersEntity> orderEntity = ordersRepository.findId(id);
        for (OrdersEntity ordersEntity : orderEntity){
            System.out.println(ordersEntity.toString());
        }

    }
    public static void findByCurrentMonth(){
        List<OrdersEntity> ordersEntityList = ordersRepository.findByCurrentMonth();
        for (OrdersEntity ordersEntity : ordersEntityList){
            System.out.println(ordersEntity.toString());
        }
    }
    public static void sumPrice(double price){
        List<OrdersEntity> ordersEntityList = ordersRepository.sumPrice(price);
        for (OrdersEntity ordersEntity :ordersEntityList){
            System.out.println(ordersEntity.toString());
        }
    }
    public static void findProduct(String name){
        List<OrdersEntity> ordersEntityList = ordersRepository.findProduct(name);
        for (OrdersEntity ordersEntity :ordersEntityList){
            System.out.println(ordersEntity.toString());
        }
    }


}