package ru.sergeysemenov.spring_test.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sergeysemenov.spring_test.enteties.Line;

@Repository
public interface LineRepository extends CrudRepository<Line, Long> {

    Boolean existsLineByProductId(Long productId);

}

