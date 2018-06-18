package com.nagham.service;


import com.nagham.model.Package;
import com.nagham.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("packageService")
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepository packageRepository;
    @Override
    public void savePackage(Package aPackage) {
        packageRepository.save(aPackage);
    }

    @Override
    public List<Package> findAll() {
        return null;
    }

    @Override
    public Package findOne() {
        return null;
    }

    @Override
    public Package findByName(String name) {
        return packageRepository.findByName(name);
    }

}
