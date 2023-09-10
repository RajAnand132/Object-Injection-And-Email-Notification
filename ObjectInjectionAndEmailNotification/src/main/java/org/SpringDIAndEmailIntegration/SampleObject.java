package org.SpringDIAndEmailIntegration;
public class SampleObject {
    private String message;
    public SampleObject(String message) {
//        System.out.println("SampleObject class is called !!!!!!!!!!!!");
        this.message = message;
        System.out.println(message);
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
