package com.Kcas.Library.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, Long> {
    Groups findAllById(Long id);
}
