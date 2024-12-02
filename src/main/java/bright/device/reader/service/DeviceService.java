package bright.device.reader.service;

import bright.device.reader.model.CumulativeCountResponse;
import bright.device.reader.model.TimestampResponse;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
public class DeviceService {

    public TimestampResponse getLatestTimestamp(String deviceId) {
        return new TimestampResponse(LocalDateTime.now());
    }

    public CumulativeCountResponse getReadingCount(String deviceId) {
        return new CumulativeCountResponse(0);
    }
}
