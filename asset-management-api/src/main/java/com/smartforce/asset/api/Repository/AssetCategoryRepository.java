package com.smartforce.asset.api.Repository;

import com.smartforce.asset.api.Model.AssetCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface AssetCategoryRepository extends MongoRepository<AssetCategory, String> {
    Optional<AssetCategory> findByCategoryName(String categoryName);
}
