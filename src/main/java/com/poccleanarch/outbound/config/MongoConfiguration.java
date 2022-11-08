package com.poccleanarch.outbound.config;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

    @Configuration
    @Import(value = MongoAutoConfiguration.class)
    public class MongoConfiguration {

        @Bean
        public MongoCustomConversions customConversions() {
            return new MongoCustomConversions(
                    List.of(DateToOffsetDateTimeConverter.INSTANCE, OffsetDateTimeToDateConverter.INSTANCE));
        }

        @ReadingConverter
        public static final class DateToOffsetDateTimeConverter
                implements Converter<Date, OffsetDateTime> {

            public static final DateToOffsetDateTimeConverter INSTANCE =
                    new DateToOffsetDateTimeConverter();

            private DateToOffsetDateTimeConverter() {}

            @Override
            public OffsetDateTime convert(final Date date) {
                return date != null ? OffsetDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC) : null;
            }
        }

        @WritingConverter
        public static final class OffsetDateTimeToDateConverter
                implements Converter<OffsetDateTime, Date> {

            public static final OffsetDateTimeToDateConverter INSTANCE =
                    new OffsetDateTimeToDateConverter();

            private OffsetDateTimeToDateConverter() {}

            @Override
            public Date convert(final OffsetDateTime offsetDateTime) {
                if (offsetDateTime == null) {
                    return null;
                }
                return Date.from(offsetDateTime.toInstant());
            }
        }
}
