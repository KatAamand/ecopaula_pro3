package org.ecopaula.server.util.converters;

import com.google.protobuf.Timestamp;
import java.time.Instant;
import java.util.Date;

public class DateConverter {
    public Timestamp sqlDateToProtoTimestamp(Date sqlDate) {
        Instant instant = sqlDate.toInstant();

        return Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
    }
}
