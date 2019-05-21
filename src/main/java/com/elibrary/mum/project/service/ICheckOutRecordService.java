package com.elibrary.mum.project.service;

import com.elibrary.mum.project.model.CheckOutRecord;
import com.elibrary.mum.project.model.User;

import java.util.List;
import java.util.Optional;

public interface ICheckOutRecordService {
    CheckOutRecord addCheckOutRecord(CheckOutRecord checkOutRecord);
    List<CheckOutRecord> getCheckOutRecords();
    Optional<CheckOutRecord> findByCheckOutRecordId(Long checkOutRecordId);
    void delete(CheckOutRecord checkOutRecord);
}
