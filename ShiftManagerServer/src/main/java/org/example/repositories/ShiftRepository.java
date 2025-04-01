package org.example.repositories;

import org.example.domain.entities.Shift;
import org.example.domain.entities.ShiftAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface ShiftRepository extends JpaRepository<Shift, UUID> {
}
