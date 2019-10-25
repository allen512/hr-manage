package com.example.spring.util;

import com.example.spring.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;


@Slf4j
public class MailUtil implements Runnable {
    private Employee employee;
    private JavaMailSender mailSender;
    private TemplateEngine templateEngine;
    private String from;

    public MailUtil(Employee employee, JavaMailSender mailSender, TemplateEngine templateEngine, String from) {
        this.employee = employee;
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
        this.from = from;
    }


    @Override
    public void run() {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(from);
            helper.setTo(employee.getEmail());
            helper.setSubject("XXX集团：通知");

            Context ctx = new Context();
            ctx.setVariable("name", employee.getName());
            ctx.setVariable("workID", employee.getWorkID());
            ctx.setVariable("contractTerm", employee.getContractTerm());
            ctx.setVariable("beginContract", employee.getBeginContract());
            ctx.setVariable("endContract", employee.getEndContract());
            ctx.setVariable("departmentName", employee.getDepartmentName());
            ctx.setVariable("posName", employee.getPosName());

            String mailText = templateEngine.process("/mail.html", ctx);
            helper.setText(mailText, true);
            mailSender.send(message);
            log.info("邮件已发送！");
        } catch (MessagingException e) {
            log.error("邮件发送失败！");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }

    }
}
