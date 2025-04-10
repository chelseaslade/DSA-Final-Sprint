package org.keyin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BSTRepository extends JpaRepository<BSTEntity, Long> {
}
