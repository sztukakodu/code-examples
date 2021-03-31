package com.example.testingscheduled;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

@Service
class MailService {
    private final LongAdder counter = new LongAdder();

    public void sendEmails() {
        System.out.println("Would send emails...");
        counter.increment();
    }

    public long sentEmailsCount() {
        return counter.sum();
    }
}
