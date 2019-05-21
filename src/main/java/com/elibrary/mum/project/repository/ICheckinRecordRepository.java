package com.elibrary.mum.project.repository;

import com.elibrary.mum.project.model.CheckinRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICheckinRecordRepository extends JpaRepository<CheckinRecord,Long> {
}
