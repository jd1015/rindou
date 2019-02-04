package com.github.jd1015.rindou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@SpringBootApplication
public class RindouApplication {

  public static void main(String[] args) {
    try (ConfigurableApplicationContext ctx = SpringApplication.run(RindouApplication.class, args)) {
      ctx.getBean(RindouApplication.class).sendMail();
    }
  }

  @Autowired
  private MailSender sender;

  public void sendMail() {
    SimpleMailMessage msg = new SimpleMailMessage();

    msg.setFrom("test@example.com");
    msg.setTo("test@example.com");
    msg.setSubject("テストメール");
    msg.setText("Spring Boot より本文送信");

    this.sender.send(msg);
  }
}
