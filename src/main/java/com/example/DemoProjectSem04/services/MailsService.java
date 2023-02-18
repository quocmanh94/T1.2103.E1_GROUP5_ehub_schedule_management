/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbuser;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class MailsService {
    @Autowired
    private JavaMailSender mailSender;
    
    public void sendEmail(Tbuser user, String siteURL) throws MessagingException, UnsupportedEncodingException {
        // import java spring-context-support 3.0.5.release
        String subject = "Reset Password";
        String senderName = "Ehub English";
        String mailContent = "<p> Dear Mrs/Mr " + user.getFullname() + ", </p>";
        mailContent +="<p>Here Your Password Is: 123</p>";
        
        //String verifyURL = siteURL + "/verify?code=" + employee.getVerificationcode();
        //mailContent += "<h3> <a href=\"" + verifyURL + "\">VERIFY</a> </h3>";
        
        mailContent += "<p>Thank You<br/>Ehub English</p>";
        
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
        helper.setFrom("ndtrong1803@gmail.com", senderName);
        helper.setTo(user.getUseremail());
        helper.setSubject(subject);
        
        helper.setText(mailContent, true);
        
        mailSender.send(message);
    }
}
