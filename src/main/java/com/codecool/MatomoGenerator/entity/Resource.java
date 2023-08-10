package com.codecool.MatomoGenerator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String apiVersion;

    private String kind;

    @Embedded
    private Metadata metadata;

    @Embedded
    private Spec spec;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class Metadata {
        private String name;
        private String namespace;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class Spec {
        private String host;
    }
}
