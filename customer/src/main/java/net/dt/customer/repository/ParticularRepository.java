package net.dt.customer.repository;

import net.dt.customer.entities.Particular;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticularRepository extends JpaRepository<Particular,String> {
}
