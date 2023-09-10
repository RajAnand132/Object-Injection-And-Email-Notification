package org.SpringDIAndEmailIntegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SampleController {
    @Autowired // Spring automatically injects the SampleObject bean here.
    private SampleObject sampleObject;
    @Autowired  // Spring automatically injects the MailHandlerBase bean here.
    private MailHandlerBase mailService;

    @GetMapping("MappingCall/SampleObject/getMessageTest")
    public String getMessageTest (){
        return sampleObject.getMessage();
    }
    @PutMapping("MappingCall/SmapleObject/setMessageTest/{msg}")
    public void setMessageTest(@PathVariable String msg){
        sampleObject.setMessage(msg);
    }

    @GetMapping("getMail/Object")
    public String getMappings() {
        mailService.sendMail(sampleObject.toString());
        return "Mail has been sent with current object !!!!!!!!!!!";
    }

}
