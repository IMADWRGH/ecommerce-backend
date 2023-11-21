package com.IMADWRGH.ecommercebackend.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;

@Entity
@Table(name = "web_order_quantities")
public class WebOrderQuantities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;


    /////////Relationship with Product  & Order /////////////
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id",nullable = false)
    private WebOrder order;

     //////Getter & Setter ///////////////////////


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public WebOrder getOrder() {
        return order;
    }

    public void setOrder(WebOrder webOrder) {
        this.order = webOrder;
    }
}
