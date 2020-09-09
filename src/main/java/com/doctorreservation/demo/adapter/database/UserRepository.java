package com.doctorreservation.demo.adapter.database;

import com.doctorreservation.demo.adapter.entity.User;

public interface UserRepository extends MyRepository<User> {

    User findByUsername(String username);

}
