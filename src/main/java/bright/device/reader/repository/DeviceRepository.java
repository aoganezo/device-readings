package bright.device.reader.repository;

import bright.device.reader.repository.entity.DeviceReadings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DeviceRepository {

    public interface DeviceReadingsRepository extends CrudRepository<DeviceReadings, Integer> {}
}
