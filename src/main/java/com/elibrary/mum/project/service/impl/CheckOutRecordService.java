package com.elibrary.mum.project.service.impl;

import com.elibrary.mum.project.model.CheckOutRecord;
import com.elibrary.mum.project.repository.IChecKOutRecordRepository;
import com.elibrary.mum.project.service.ICheckOutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckOutRecordService implements ICheckOutRecordService {
    @Autowired
    public IChecKOutRecordRepository checKOutRecordRepository;
    @Override
    public CheckOutRecord addCheckOutRecord(CheckOutRecord checkOutRecord) {
        return checKOutRecordRepository.save(checkOutRecord);
    }

    @Override
    public List<CheckOutRecord> getCheckOutRecords() {
        return checKOutRecordRepository.findAll();
    }

    @Override
    public Optional<CheckOutRecord> findByCheckOutRecordId(Long checkOutRecordId) {
        return checKOutRecordRepository.findById(checkOutRecordId);
    }

    @Override
    public void delete(CheckOutRecord checkOutRecord) {
           checKOutRecordRepository.delete(checkOutRecord);
    }
}
