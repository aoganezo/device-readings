package bright.device.reader.repository.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class DeviceReadings {
    @Id
    private UUID deviceId;
    private int count;
    private LocalDateTime timestamp;
}
