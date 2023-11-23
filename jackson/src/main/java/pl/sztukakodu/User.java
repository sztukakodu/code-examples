package pl.sztukakodu;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import one.util.streamex.EntryStream;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

record User(@JsonSerialize(using = NonEmptySerializer.class) Map<String, Object> settings) {
}

class NonEmptySerializer extends JsonSerializer<Map<String, Object>> {

    @Override
    public void serialize(Map<String, Object> map, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        Map<String, Object> filteredMap = EntryStream.of(map)
            .filterValues(Objects::nonNull)
            .toMap();
        gen.writeObject(filteredMap);
    }
}
