package net.dt.hosting.openfeign;

import net.dt.hosting.entities.Pack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="PACK-SERVICE")
public interface PackRestClient {

    @GetMapping(path = "/api/getpacks/{id}")
    Pack getPacks(@PathVariable(name = "id") String id);
    @GetMapping(path = "/api/getpacks")
    List<Pack> allPacks();
}

