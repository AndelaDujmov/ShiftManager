package org.example.repositories;

import org.example.domain.entities.Shift;
import org.example.domain.entities.ShiftAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface ShiftRepository extends JpaRepository<Shift, UUID> {

    @Query(value = "SELECT s FROM Shift s WHERE s.isDeleted = true")
    public List<Shift> showDeleted();

    @Query(value = "SELECT s FROM Shift s WHERE s.type = :type")
    public Shift findByType(@Param("type") String type);
}
