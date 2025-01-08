package com.smartforce.task.api.Repository;

import com.smartforce.task.api.Model.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findByProjectTitle(String projectTitle);
}
