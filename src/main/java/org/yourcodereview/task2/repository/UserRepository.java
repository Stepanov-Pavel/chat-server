package org.yourcodereview.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yourcodereview.task2.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
