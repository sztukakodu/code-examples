package com.example.testingscheduled;

import com.jayway.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest(properties = {
    "app.mail-service.rate=PT1S"
})
class MailJobIT {

    @Autowired
    MailService mailService;

    @Test
    public void shouldSendMails() {
        Awaitility.await()
                  .atMost(5, TimeUnit.SECONDS)
                  .until(() -> mailService.sentEmailsCount() > 0);
    }

}
