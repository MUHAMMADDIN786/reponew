package com.code.moneytrackingappbe.repository;


import com.code.moneytrackingappbe.model.MoneyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface MoneyTransactionRepo extends JpaRepository<MoneyTransaction,Integer> {
}
