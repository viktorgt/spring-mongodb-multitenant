package io.swcode.multitenant.demo.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    @Id
    @NonNull
    private final UUID userId;
    @NonNull
    private final String firstName;
    @NonNull
    private final String lastName;

    public static User of(final String firstName, final String lastName) {
        return new User(UUID.randomUUID(), firstName, lastName);
    }
}
