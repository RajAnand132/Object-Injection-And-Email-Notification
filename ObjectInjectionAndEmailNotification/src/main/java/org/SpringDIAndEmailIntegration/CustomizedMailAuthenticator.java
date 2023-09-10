package org.SpringDIAndEmailIntegration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
@Component
public class CustomizedMailAuthenticator extends Authenticator {
    MailConstants mailConst;

    @Override
    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(mailConst.SENDER, mailConst.APP_PASSWORD);

    }
}
