package net.dt.hosting.repositories;

import net.dt.hosting.entities.Customer;
import net.dt.hosting.entities.Hosting;
import net.dt.hosting.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostingRepository extends JpaRepository<Hosting,String> {
    List<Hosting> findByCustomerId(String customerId);
    List<Hosting> findByPackId(String packId);
}






























