package acme.features.anonymous.task;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousTaskRepository extends AbstractRepository {

    @Query("select t from Task t where t.privacy = false and t.finished = false")
    Collection<Task> findtaskspublinonfinished();
    
    @Query("select t from Task t where t.id = ?1")
    Task findOneTaskById(int id);

}