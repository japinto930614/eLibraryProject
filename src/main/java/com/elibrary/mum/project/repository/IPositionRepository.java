package com.elibrary.mum.project.repository;

import com.elibrary.mum.project.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
