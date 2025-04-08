package org.example.repositories.impl;

import org.example.domain.entities.Shift;
import org.example.domain.entities.ShiftAssignment;
import org.example.repositories.ShiftRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

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

    @Override
    public void flush() {

    }

    @Override
    public <S extends Shift> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Shift> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Shift> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> uuids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Shift getOne(UUID uuid) {
        return null;
    }

    @Override
    public Shift getById(UUID uuid) {
        return null;
    }

    @Override
    public Shift getReferenceById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends Shift> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Shift> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Shift> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Shift> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Shift> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Shift> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Shift, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Shift> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Shift> findAll(Pageable pageable) {
        return null;
    }
}
