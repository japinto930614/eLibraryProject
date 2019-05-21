package com.elibrary.mum.project.service.impl;

import com.elibrary.mum.project.model.Position;
import com.elibrary.mum.project.repository.IPositionRepository;
import com.elibrary.mum.project.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.crypto.spec.PSource;
import java.util.List;
import java.util.Optional;

@Service
public class PositionService implements IPositionService {

    @Autowired
    public IPositionRepository positionRepository;

    @Override
    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public void removePosition(Position position) {
        positionRepository.delete(position);
    }

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> findPositionByNumber(int positionId) {
        return positionRepository.findById(positionId);
    }
}
