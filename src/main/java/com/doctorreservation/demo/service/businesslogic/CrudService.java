package com.doctorreservation.demo.service.businesslogic;

import com.doctorreservation.demo.adapter.database.MyRepository;
import com.doctorreservation.demo.adapter.entity.BaseEntity;

import java.util.List;

public abstract class CrudService<T extends BaseEntity> {

    private final MyRepository<T> repository;

    public CrudService(MyRepository<T> repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    T save(T entity) {
        return repository.save(entity);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

}
