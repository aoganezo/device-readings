package bright.device.reader.model;

public record DeviceReadingRequest(
        String id,
        DeviceReading[] readings
) {
}
