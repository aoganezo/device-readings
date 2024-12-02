package bright.device.reader.repository;

import bright.device.reader.repository.entity.DeviceReadingEntity;
import org.springframework.data.domain.Limit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceReadingsRepository extends CrudRepository<DeviceReadingEntity, String> {
    DeviceReadingEntity findFirstByDeviceIdOrderByTimestampDesc(String deviceId, Limit limit);

    DeviceReadingEntity[] findAllByDeviceId(String deviceId);
}
