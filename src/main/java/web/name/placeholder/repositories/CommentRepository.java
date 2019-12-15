package web.name.placeholder.repositories;

import org.springframework.data.repository.CrudRepository;
import web.name.placeholder.models.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository  extends CrudRepository<Comment, Long> {
    Comment findAllByUserId(Long userId);

    Comment findOne(Long userId);
}
