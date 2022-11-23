package com.code.moneytrackingappbe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * In this model there must be 1:M Relationship with @TransactionAsset.java model
 */
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double amount;
    private String description;
    @CreatedDate
    @CreationTimestamp
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date createdAt;

    @OneToMany(mappedBy = "moneyTransaction",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<TransactionAsset> assets=new ArrayList<>();

}
