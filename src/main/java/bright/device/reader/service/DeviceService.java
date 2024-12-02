package bright.device.reader.service;

import bright.device.reader.model.CumulativeCountResponse;
import bright.device.reader.model.DeviceReading;
import bright.device.reader.model.DeviceReadingRequest;
import bright.device.reader.model.TimestampResponse;
import bright.device.reader.repository.DeviceReadingsRepository;
import bright.device.reader.repository.entity.DeviceReadingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    DeviceReadingsRepository deviceRepository;

    public TimestampResponse getLatestTimestamp(String deviceId) {
        DeviceReadingEntity deviceReading = deviceRepository.findFirstByDeviceIdOrderByTimestampDesc(deviceId, Limit.of(1));
        return new TimestampResponse(deviceReading.getTimestamp());
    }

    public CumulativeCountResponse getReadingCount(String deviceId) {
        DeviceReadingEntity[] deviceReadings = deviceRepository.findAllByDeviceId(deviceId);
        int cumulativeSum = 0;
        for (DeviceReadingEntity reading : deviceReadings) {
            cumulativeSum += reading.getCount();
        }
        return new CumulativeCountResponse(cumulativeSum);
    }

    public void updateDeviceReadings(DeviceReadingRequest newDeviceReadings) {
        String deviceId = newDeviceReadings.id();
        DeviceReading[] newReadings = newDeviceReadings.readings();
        List<Date> timestamps = new ArrayList<>();
        List<DeviceReadingEntity> deviceReadingEntities = new ArrayList<>();

        for (DeviceReading deviceReading : newReadings) {
            Date readingTimestamp = deviceReading.timestamp();
            // ignore timestamp duplicates
            if (timestamps.contains(readingTimestamp)) {
                continue;
            }
            timestamps.add(readingTimestamp);
            deviceReadingEntities.add(new DeviceReadingEntity(deviceId, deviceReading.count(), readingTimestamp));
        }
        deviceRepository.saveAll(deviceReadingEntities);
    }
}
