package io.joyrpc.codec.serialization.protostuff.schema;

/*-
 * #%L
 * joyrpc
 * %%
 * Copyright (C) 2019 joyrpc.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import io.protostuff.Input;
import io.protostuff.Output;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class LocalDateTimeSchema extends AbstractJava8Schema<LocalDateTime> {

    public static final LocalDateTimeSchema INSTANCE = new LocalDateTimeSchema();
    public static final String DATE = "date";
    public static final String TIME = "time";

    protected static final String[] FIELD_NAMES = new String[]{DATE, TIME};

    protected static final Map<String, Integer> FIELD_MAP = new HashMap(2);

    protected static Field FIELD_DATE = getWriteableField(LocalDateTime.class, DATE);
    protected static Field FIELD_TIME = getWriteableField(LocalDateTime.class, TIME);

    static {
        FIELD_MAP.put(DATE, 1);
        FIELD_MAP.put(TIME, 2);
    }

    public LocalDateTimeSchema() {
        super(LocalDateTime.class);
    }

    @Override
    public String getFieldName(int number) {
        return FIELD_NAMES[number];
    }

    @Override
    public int getFieldNumber(final String name) {
        return FIELD_MAP.get(name);
    }

    @Override
    public LocalDateTime newMessage() {
        return LocalDateTime.now();
    }

    @Override
    public void mergeFrom(final Input input, final LocalDateTime message) throws IOException {
        while (true) {
            int number = input.readFieldNumber(this);
            switch (number) {
                case 0:
                    return;
                case 1:
                    LocalDate localDate = LocalDate.now();
                    input.mergeObject(localDate, LocalDateSchema.INSTANCE);
                    setValue(FIELD_DATE, message, localDate);
                    break;
                case 2:
                    LocalTime localTime = LocalTime.now();
                    input.mergeObject(localTime, LocalTimeSchema.INSTANCE);
                    setValue(FIELD_TIME, message, localTime);
                    break;
                default:
                    input.handleUnknownField(number, this);
            }
        }
    }

    @Override
    public void writeTo(final Output output, final LocalDateTime message) throws IOException {
        output.writeObject(1, message.toLocalDate(), LocalDateSchema.INSTANCE, false);
        output.writeObject(2, message.toLocalTime(), LocalTimeSchema.INSTANCE, false);
    }
}
