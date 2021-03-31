package com.example.testingscheduled;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class MailJob {
    private final MailService mailService;

    @Scheduled(
        initialDelayString = "${app.mail-service.rate}",
        fixedRateString = "${app.mail-service.rate}"
    )
    public void run() {
        mailService.sendEmails();
    }

}
