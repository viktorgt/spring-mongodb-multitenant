package io.swcode.multitenant.demo.domain;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Value
@Document
public class User {
    @Id
    private final UUID userId;
    private final String firstName;
    private final String lastName;
}
