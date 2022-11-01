package net.dt.paiement.repository;

import net.dt.paiement.entities.MoyenPaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MoyenPaiementRepository extends JpaRepository<MoyenPaiement,String> {
}
