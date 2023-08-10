package com.codecool.MatomoGenerator.repository;

import com.codecool.MatomoGenerator.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    boolean existsByMetadata_NameAndMetadata_Namespace(String name, String nameSpace);

}
