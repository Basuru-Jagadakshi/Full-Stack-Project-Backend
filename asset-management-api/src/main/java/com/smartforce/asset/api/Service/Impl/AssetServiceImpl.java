package com.smartforce.asset.api.Service.Impl; // Corrected package name

import com.smartforce.asset.api.Model.Asset;
import com.smartforce.asset.api.Model.AssetCategory;
import com.smartforce.asset.api.Repository.AssetCategoryRepository;
import com.smartforce.asset.api.Repository.AssetRepository;
import com.smartforce.asset.api.Service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetServiceImpl implements AssetService { // Ensuring correct interface implementation

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private AssetCategoryRepository assetCategoryRepository; // Added repository for category validation

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @Override
    public Asset saveAsset(Asset asset) {
        // Validate category before saving
        Optional<AssetCategory> category = assetCategoryRepository.findByCategoryName(asset.getCategoryName());
        if (category.isEmpty()) {
            throw new IllegalArgumentException("Invalid category: Category does not exist");
        }
        return assetRepository.save(asset);
    }

    @Override
    public void deleteAsset(String id) {
        assetRepository.deleteById(id);
    }

    @Override
    public Asset updateAsset(String id, Asset asset) {
        Optional<Asset> existingAsset = assetRepository.findById(id);
        if (existingAsset.isPresent()) {
            Asset updatedAsset = existingAsset.get();
            updatedAsset.setAssetName(asset.getAssetName());
            updatedAsset.setQuantity(asset.getQuantity());
            updatedAsset.setType(asset.getType());
            updatedAsset.setDepartmentName(asset.getDepartmentName());

            // Validate category before updating
            Optional<AssetCategory> category = assetCategoryRepository.findByCategoryName(asset.getCategoryName());
            if (category.isEmpty()) {
                throw new IllegalArgumentException("Invalid category: Category does not exist");
            }
            updatedAsset.setCategoryName(asset.getCategoryName());

            return assetRepository.save(updatedAsset);
        } else {
            throw new IllegalArgumentException("Asset not found");
        }
    }
}
