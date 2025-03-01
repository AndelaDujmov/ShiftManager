package org.example.repositories.impl;

import org.example.domain.entities.Shift;
import org.example.domain.entities.ShiftAssignment;
import org.example.repositories.ShiftAssignmentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ShiftAssignmentRepositoryImplementation implements ShiftAssignmentRepository {

    @Override
    public <S extends ShiftAssignment> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ShiftAssignment> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ShiftAssignment> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public Iterable<ShiftAssignment> findAll() {
        return null;
    }

    @Override
    public Iterable<ShiftAssignment> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(ShiftAssignment entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends ShiftAssignment> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
