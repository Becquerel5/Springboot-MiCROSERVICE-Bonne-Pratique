package net.dt.hosting.dto;

import lombok.*;
import net.dt.hosting.entities.Hosting;
import net.dt.hosting.entities.Renew;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RenewRequestDTO extends HostingRequestDTO {

    private String id;
    private LocalDate dateRenew = java.time.LocalDate.now();

}
