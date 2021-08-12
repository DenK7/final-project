package ru.otus.telegram.database.caretaker.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.telegram.database.caretaker.entity.DBServer;

import java.util.Optional;

public interface DBServerRepositories extends MongoRepository<DBServer, String> {
    Optional<DBServer> findDBServerByServerName(String serverName);
}
