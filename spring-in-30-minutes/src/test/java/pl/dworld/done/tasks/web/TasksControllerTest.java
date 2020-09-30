package pl.dworld.done.tasks.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.dworld.done.tasks.web.TasksController.CreateTaskCommand;

import static org.hamcrest.Matchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TasksControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void shouldAddTasks() throws Exception {
        // given
        CreateTaskCommand command = CreateTaskCommand
            .builder()
            .title("Ustalic wymagane parametry")
            .priority(true)
            .build();

        // expect
        mockMvc
            .perform(
                post("/tasks")
                    .contentType(APPLICATION_JSON)
                    .content(mapper.writeValueAsString(command))
            )
            .andExpect(status().isCreated());

        // when
        mockMvc.perform(get("/tasks"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("$", hasSize(1)))
               .andExpect(jsonPath("$[0].title", is("Ustalic wymagane parametry")))
               .andExpect(jsonPath("$[0].createdAt", not(empty())));
    }
}