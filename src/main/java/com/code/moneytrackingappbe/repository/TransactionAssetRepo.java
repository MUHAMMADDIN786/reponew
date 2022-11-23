package com.code.moneytrackingappbe.repository;


import com.code.moneytrackingappbe.model.TransactionAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionAssetRepo  extends JpaRepository<TransactionAsset,Integer> {
}
