package ru.sergeysemenov.spring_test.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeysemenov.spring_test.enteties.Line;
import ru.sergeysemenov.spring_test.repositories.LineRepository;

@Service
public class LineService {
    private LineRepository lineRepository;

    @Autowired
    public void setLineRepository(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public Boolean checkIfExist(Long productId){
        return lineRepository.existsLineByProductId(productId);
    }

    public Line saveOrUpdateLine (Line line){
        return lineRepository.save(line);
    }
}
