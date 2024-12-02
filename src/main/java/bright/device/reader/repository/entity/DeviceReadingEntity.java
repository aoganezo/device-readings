package bright.device.reader.repository.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "DeviceReadings")
@IdClass( DeviceReadingPrimaryKey.class )
public class DeviceReadingEntity {
    @Id
    private String deviceId;
    private int count;
    @Id
    private Date timestamp;

    public DeviceReadingEntity() {}

    public DeviceReadingEntity(String deviceId, int count, Date timestamp) {
        this.deviceId = deviceId;
        this.count = count;
        this.timestamp = timestamp;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public int getCount() {
        return count;
    }

    public Date getTimestamp() {
        return timestamp;
    }

}
