package com.squirrel.realtor.api.dto;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter @Setter @ToString
@RequiredArgsConstructor
@Document(collection = "agent")
public class Agent {
    @Id
    private String agentId;

    @Indexed
    private String firstName;
    private String lastName;
    private String phone;
    private String licenseNumber;
    private String dateStarted;
}
