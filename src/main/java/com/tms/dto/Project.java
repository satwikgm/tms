package com.tms.dto;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Introspected
public class Project {

    private ObjectId id;
    private String name;
    private String description;
    private String projectId;
    private String status;
    private String assignedTo;
}
