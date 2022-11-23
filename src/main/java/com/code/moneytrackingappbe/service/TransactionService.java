package com.code.moneytrackingappbe.service;

import com.code.moneytrackingappbe.model.MoneyTransaction;
import com.code.moneytrackingappbe.model.TransactionAsset;
import com.code.moneytrackingappbe.repository.MoneyTransactionRepo;
import com.code.moneytrackingappbe.repository.TransactionAssetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private MoneyTransactionRepo repo;
    @Autowired
    private ImageService imageService;

    @Autowired
    private TransactionAssetRepo assetRepo;
    public List<MoneyTransaction> findAll() {
        return repo.findAll();
    }

    public MoneyTransaction createTransaction(String description,
                                              Double amount, List<MultipartFile> files) {
        MoneyTransaction transaction=new MoneyTransaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);
        if(files.isEmpty()){
        List<TransactionAsset> assetList=new ArrayList<>();
        for(MultipartFile file1:files)
        {
            String url=imageService.saveImages(file1);
            TransactionAsset newAsset= new TransactionAsset();
            newAsset.setImgUrl(url);
            TransactionAsset savedAsset=assetRepo.save(newAsset);
            assetList.add(savedAsset);
        }
        transaction.setAssets(assetList);}
        return repo.save(transaction);
    }
}
