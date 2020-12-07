package com.example.testingscheduled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MailJob.class, MailService.class})
class MailJobTest {

    @Autowired
    MailService mailService;

    @Autowired
    MailJob mailJob;

    @Test
    public void shouldSendMails() {
        // when
        mailJob.run();

        // then
        assertEquals(1L, mailService.sentEmailsCount());
    }

}