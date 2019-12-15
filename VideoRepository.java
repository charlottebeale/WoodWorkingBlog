package web.name.placeholder.repositories;

import org.springframework.data.repository.CrudRepository;
import web.name.placeholder.models.*;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long> {
}
