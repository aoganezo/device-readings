package bright.device.reader.repository.entity;

import java.io.Serializable;
import java.util.Date;

public class DeviceReadingPrimaryKey implements Serializable {
    private String deviceId;
    private Date timestamp;

    DeviceReadingPrimaryKey() {}
}

