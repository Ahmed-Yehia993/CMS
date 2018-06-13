package com.tie.service;

import com.tie.model.Package;

import java.util.List;

public interface PackageService {

    public void savePackage(Package aPackage);
    public List<Package> findAll();
    Package findOne();
    Package findByName(String name);

}
