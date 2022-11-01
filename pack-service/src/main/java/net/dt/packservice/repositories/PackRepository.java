package net.dt.packservice.repositories;

import net.dt.packservice.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackRepository extends JpaRepository<Pack,String> {
}
