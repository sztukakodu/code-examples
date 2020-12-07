package com.example.testingscheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.CountDownLatch;

@EnableScheduling
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DemoApplication.class, args);

		final CountDownLatch closeLatch = new CountDownLatch(1);
		Runtime.getRuntime().addShutdownHook(new Thread(closeLatch::countDown));
		closeLatch.await();
	}

}
