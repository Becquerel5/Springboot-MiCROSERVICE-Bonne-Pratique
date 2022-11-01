package net.dt.packservice.repositories;

import net.dt.packservice.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffreRepository extends JpaRepository<Offre,String> {
}
