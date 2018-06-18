package com.nagham.repository;

import com.nagham.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Ahmed El-Deeb
 *
 */
@Repository("packageRepository")
public interface PackageRepository  extends JpaRepository<Package, Integer> {
    Package findByName(String name);
}
