package com.smartforce.asset.api.Service.Impl;

import com.smartforce.asset.api.Model.Asset;
import com.smartforce.asset.api.Repository.AssetRepository;
import com.smartforce.asset.api.Service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> getAllAssets(){
        return assetRepository.findAll();
    }

    public Asset addAsset(Asset asset){
        return assetRepository.save(asset);
    }

    public Asset updateAsset(String id, Asset asset){
        Asset existingAsset = assetRepository.findById(id).orElseThrow(() -> new RuntimeException());

        existingAsset.setAssetName(asset.getAssetName());
        existingAsset.setQuantity(asset.getQuantity());
        existingAsset.setType(asset.getType());

        assetRepository.save(existingAsset);

        return existingAsset;

    }

    public void deleteAsset(String id){
        assetRepository.findById(id).orElseThrow(() -> new RuntimeException());
        assetRepository.deleteById(id);
    }
}
