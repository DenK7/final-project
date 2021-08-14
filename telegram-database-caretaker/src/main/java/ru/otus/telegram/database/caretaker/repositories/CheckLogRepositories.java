package ru.otus.telegram.database.caretaker.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.otus.telegram.database.caretaker.entity.CheckLog;

import java.util.Date;
import java.util.List;

public interface CheckLogRepositories extends MongoRepository<CheckLog, String> {

    @Query("{'check_date': {$gte: ?0, $lte:?1 }}")
    List<CheckLog> findAllByCheckDateBetween(Date dateFrom, Date dateTo);
}
