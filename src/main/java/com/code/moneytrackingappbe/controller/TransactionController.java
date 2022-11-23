package com.code.moneytrackingappbe.controller;

import com.code.moneytrackingappbe.service.ImageService;
import com.code.moneytrackingappbe.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ImageService imageService;
    @GetMapping("/getAll")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(transactionService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping("/create")
    public ResponseEntity<?> createTransaction(
            @RequestParam("description") String description,
            @RequestParam("amount")Double amount,
            @RequestParam("receipts") List<MultipartFile> files) {
        try {
            return ResponseEntity.ok(transactionService.createTransaction(description,amount,files));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/getImage")
    public ResponseEntity<?> getImage(
            @RequestParam("image") String image) {
        try {
            return ResponseEntity.ok(imageService.getImage(image));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
