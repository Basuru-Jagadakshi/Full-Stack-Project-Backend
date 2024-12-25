package com.smartforce.asset.api.Service;

import com.smartforce.asset.api.Model.Asset;

import java.util.List;

public interface AssetService {

    List<Asset> getAllAssets();

    Asset addAsset(Asset asset);

    Asset updateAsset(String id, Asset asset);

    void deleteAsset(String id);
}
