package org.example.repositories.impl;

import org.example.domain.entities.Shift;
import org.example.domain.entities.ShiftAssignment;
import org.example.repositories.ShiftRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ShiftRepositoryImplementation implements ShiftRepository {

    @Override
    public <S extends Shift> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Shift> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Shift> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public List<Shift> findAll() {
        return List.of();
    }

    @Override
    public List<Shift> findAllById(Iterable<UUID> uuids) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(Shift entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends Shift> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
