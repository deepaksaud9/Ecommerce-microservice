package com.ecom.product.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name",nullable = false)
    private String productName;

    @Column(name = "product_title",nullable = false)
    private String title;

    @Column(name = "product_description",nullable = false)
    private String productDescription;

    @Column(name = "product_price",nullable = false)
    private BigDecimal productPrice;

   /* @Column(name = "product_image")
    private MultipartFile photo;*/
}
