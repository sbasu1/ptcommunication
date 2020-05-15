package org.launchcode.ptcommunications.repository;

import org.launchcode.ptcommunications.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findByName(String name);
}
