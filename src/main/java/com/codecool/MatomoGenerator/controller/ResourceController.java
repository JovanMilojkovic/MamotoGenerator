package com.codecool.MatomoGenerator.controller;

import com.codecool.MatomoGenerator.entity.Resource;
import com.codecool.MatomoGenerator.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/matomo/resource")
public class ResourceController {
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;

    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewResource(@RequestBody Resource resource) {
        return resourceService.saveResource(resource);
    }

    @GetMapping("/all_resources")
    public ResponseEntity<?> getAllResources(){
        return resourceService.allResources();
    }

}
