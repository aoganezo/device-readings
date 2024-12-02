package bright.device.reader.model;

import java.time.LocalDateTime;

public record DeviceReading(
        LocalDateTime timestamp,
        int count
) { }
