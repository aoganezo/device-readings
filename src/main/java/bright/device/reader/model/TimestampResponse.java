package bright.device.reader.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public record TimestampResponse(
        @JsonProperty("latest_timestamp") LocalDateTime latestTimestamp
) {}

