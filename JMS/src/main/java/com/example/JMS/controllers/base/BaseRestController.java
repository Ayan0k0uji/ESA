package com.example.JMS.controllers.base;

import com.example.JMS.dto.base.BaseDto;
import com.example.JMS.entities.base.BaseEntity;
import com.example.JMS.services.base.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseRestController<E extends BaseEntity<I>, D extends BaseDto, I>{

    private final BaseService service;

    public BaseRestController(BaseService baseService) {
        this.service = baseService;
    }

    @GetMapping
    public List<E> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public BaseEntity<I> getById(@PathVariable I id) {
        return service.findById(id);
    }

    @PutMapping
    public void add(@RequestBody D dto) {
        service.save(dto);
    }

    @PostMapping
    public void update(@RequestBody E drug) {
        service.update(drug);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable I id) {
        service.delete(id);
    }
}
