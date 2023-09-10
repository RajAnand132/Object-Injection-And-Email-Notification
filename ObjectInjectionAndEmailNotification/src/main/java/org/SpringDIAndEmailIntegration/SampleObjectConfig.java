package org.SpringDIAndEmailIntegration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SampleObjectConfig {
    @Bean // Spring automatically calls the method sampleObject bean here.
    public SampleObject sampleObject() {
        return new SampleObject("Hello from Spring!");
    }
}
