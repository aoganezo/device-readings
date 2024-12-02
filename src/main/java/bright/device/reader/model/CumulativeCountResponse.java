package bright.device.reader.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CumulativeCountResponse(
        @JsonProperty("cumulative_count") int cumulativeCount
) {}
