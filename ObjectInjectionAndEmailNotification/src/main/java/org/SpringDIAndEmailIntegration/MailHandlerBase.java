package org.SpringDIAndEmailIntegration;
import org.springframework.stereotype.Component;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
@Component
public class MailHandlerBase{
    public void sendMail(String msg)
    {
        //Properties
        Properties sysPropertiesMap = System.getProperties();

        //Adding new required properties
        sysPropertiesMap.put("mail.smtp.host","smtp.gmail.com"); //smtp server
        sysPropertiesMap.put("mail.smtp.port","465"); //server port
        sysPropertiesMap.put("mail.smtp.ssl.enable","true"); //ssl -secure socket layer
        sysPropertiesMap.put("mail.smtp.auth","true"); //authentication - auth

        //Authentication
        Authenticator mailAuthenticator = new CustomizedMailAuthenticator();
        //Session
        Session mailSession = Session.getInstance(sysPropertiesMap,mailAuthenticator);
        //Build the mail Mime message
        MimeMessage mailMessage = new MimeMessage(mailSession);
        try {
            mailMessage.setFrom(MailConstants.SENDER);
            mailMessage.setSubject("Weekly Test Answer [10-09-2023]");
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("dvilbhai373738hmail.com@gmail.com"));
            mailMessage.setText(msg);
            Transport.send(mailMessage);
        }
        catch(Exception ex)
        {
            System.out.println("Some error while preparing mail body!!!!");
            System.out.println(ex.getMessage());
        }

    }
}
