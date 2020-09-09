package com.doctorreservation.demo.adapter.database;

import com.doctorreservation.demo.adapter.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MyRepository<T extends BaseEntity> extends JpaRepository<T,Long> {
}
