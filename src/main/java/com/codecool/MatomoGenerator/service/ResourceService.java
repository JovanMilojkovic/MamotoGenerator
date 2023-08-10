package com.codecool.MatomoGenerator.service;


import com.codecool.MatomoGenerator.entity.Resource;
import com.codecool.MatomoGenerator.repository.ResourceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;

    }

    public ResponseEntity<?> saveResource(Resource resource) {
        String name = resource.getMetadata().getName();
        String namespace = resource.getMetadata().getNamespace();

        if (resourceRepository.existsByMetadata_NameAndMetadata_Namespace(name, namespace)) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Resource with the same name already exists in the namespace.");
        }

        resourceRepository.save(resource);
        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }

    public ResponseEntity<?> allResources() {
        List<Resource> listOfResources = resourceRepository.findAll();
        if (listOfResources.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("There are currently no resources");
        }
        return ResponseEntity.status(HttpStatus.OK).body(listOfResources);
    }
}
