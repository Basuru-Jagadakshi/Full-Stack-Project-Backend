package com.smartforce.asset.api.Controller;

import com.smartforce.asset.api.Model.Asset;
import com.smartforce.asset.api.Service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @GetMapping
    public List<Asset> getAllAssets(){
        return assetService.getAllAssets();
    }

    @PostMapping
    public ResponseEntity<Asset> addAsset(@RequestBody Asset asset){
        return new ResponseEntity<Asset>(assetService.addAsset(asset), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update-assets/{id}")
    public ResponseEntity<Asset> updateAsset(@PathVariable String id, @RequestBody Asset asset){
        return new ResponseEntity<Asset>(assetService.updateAsset(id, asset), HttpStatus.OK);
    }

    @DeleteMapping(value = "delete-asset/{id}")
    public ResponseEntity<String> deleteAsset(@PathVariable String id){
        assetService.deleteAsset(id);
        return new ResponseEntity<String>("Asset record is successfully deleted!", HttpStatus.OK);
    }
}
