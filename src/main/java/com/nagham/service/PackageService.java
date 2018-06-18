package com.nagham.service;

import com.nagham.model.Package;

import java.util.List;

public interface PackageService {

    public void savePackage(Package aPackage);
    public List<Package> findAll();
    Package findOne();
    Package findByName(String name);

}
