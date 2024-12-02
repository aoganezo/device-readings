package bright.device.reader.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public record TimestampResponse(
        @JsonProperty("latest_timestamp") Date latestTimestamp
) {}

