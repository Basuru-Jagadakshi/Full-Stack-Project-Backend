package com.smartforce.asset.api.Repository;

import com.smartforce.asset.api.Model.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface AssetRepository extends MongoRepository<Asset, String> {
    List<Asset> findByCategoryName(String categoryName);
}
