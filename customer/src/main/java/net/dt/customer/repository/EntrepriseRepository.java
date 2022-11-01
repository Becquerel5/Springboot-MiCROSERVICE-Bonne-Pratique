package net.dt.customer.repository;

import net.dt.customer.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise,String> {
}
