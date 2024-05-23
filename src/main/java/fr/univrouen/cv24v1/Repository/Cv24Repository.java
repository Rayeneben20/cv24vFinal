package fr.univrouen.cv24v1.Repository;

import fr.univrouen.cv24v1.Model.Cv24id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cv24Repository extends MongoRepository<Cv24id, String> {
    boolean existsById(String id);
}
