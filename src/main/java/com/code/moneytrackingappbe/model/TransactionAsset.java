package com.code.moneytrackingappbe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * In this model there must be M:1 Relationship with @TransactionAsset.java model
 */
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String imgUrl;

    @ManyToOne
    @JsonIgnore
    private MoneyTransaction moneyTransaction;

}
