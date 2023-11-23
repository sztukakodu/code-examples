package pl.sztukakodu;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

class UserTest {

    ObjectMapper mapper = new ObjectMapper();

    @Test
    @SneakyThrows
    void shouldNotSerializeEmptyValues() {
        // given
        var settings = new HashMap<String, Object>();
        settings.put("username", "John");
        settings.put("surname", "Doe");
        settings.put("address", null);
        settings.put("age", 33);
        settings.put("country", null);
        User user = new User(settings);

        // when
        String json = mapper.writeValueAsString(user);

        // then
        assertThatJson(json).isEqualTo("{settings: {surname:'Doe', username:'John', age:33}}");
    }

}
