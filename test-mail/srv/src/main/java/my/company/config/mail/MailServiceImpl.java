package my.company.config.mail;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailServiceImpl {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail() {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			mimeMessage.setSubject("1 - Subject: Test from @sap.com v3");
			mimeMessage.setFrom("pamela.piao@sap.com");
			InternetAddress[] toAddresses = InternetAddress.parse("pamela.piao@sap.com");
			mimeMessage.setRecipients(RecipientType.TO, toAddresses);
			mimeMessage.setText("Test !!");
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		try {
//			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//			
//			helper.setSubject("2- Subject: Test from @sap.com v2");
//			helper.setFrom("jane.huang@sap.com");
//            helper.setTo("pamela.piao@sap.com");
//            
//            helper.setText("Test !!", true);
//            
//		} catch (MessagingException e) {
//			System.out.print("helper error");
//			e.printStackTrace();
//		}
		

        try {
			mailSender.send(mimeMessage);
		} catch (MailAuthenticationException e) {
			System.out.print("MailAuthenticationException");
			e.printStackTrace();
		} catch (MailSendException e) {
			System.out.print("MailSendException");
			e.printStackTrace();
		}
	}
	
//	public void sendMail() {
//      SimpleMailMessage msg = new SimpleMailMessage();
//      msg.setFrom("pamela.piao9210@gmail.com");
//      msg.setTo("pamela.piao@sap.com");
//
//      msg.setSubject("Testing from Spring Boot - pamela.piao9210@gmail.com");
//      msg.setText("Hello World \n Spring Boot Email");
//
//      mailSender.send(msg);
//	}

}
