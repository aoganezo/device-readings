package bright.device.reader.model;

import java.util.Date;

public record DeviceReading(
        Date timestamp,
        int count
) { }
