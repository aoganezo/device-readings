package bright.device.reader.model;

import java.util.UUID;

public record DeviceReadingRequest(
        UUID id,
        DeviceReading[] deviceReadings
) {
}
