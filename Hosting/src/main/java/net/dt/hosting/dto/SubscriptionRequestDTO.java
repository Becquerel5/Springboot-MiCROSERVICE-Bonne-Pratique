package net.dt.hosting.dto;


import lombok.*;
import net.dt.hosting.entities.Hosting;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionRequestDTO extends HostingRequestDTO {

    private String id;
    private LocalDate dateSubscription = LocalDate.now();



}
