package com.sxx.demo.dao;

import com.sxx.demo.tableEntity.TicketsTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsDao extends JpaRepository<TicketsTable, Integer> {
    TicketsTable findByuId(String uId);
}
