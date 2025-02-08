package com.tms.repository;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import com.tms.dto.Task;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class TaskRepository {

    private final MongoClient mongoClient;

    private MongoCollection<Task> getTaskCollection() {
        MongoDatabase db = mongoClient.getDatabase("tms");
        return db.getCollection("tasks", Task.class);

    }

    public Mono<Task> saveTask(Task task) {
        return Mono.from(getTaskCollection().insertOne(task))
                .thenReturn(task);
    }
}
