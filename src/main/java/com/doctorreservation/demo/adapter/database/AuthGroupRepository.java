package com.doctorreservation.demo.adapter.database;

import com.doctorreservation.demo.adapter.entity.AuthGroup;

import java.util.List;

public interface AuthGroupRepository extends MyRepository<AuthGroup> {

    List<AuthGroup> findByUsername(String username);
}
