package org.keyin.S4Sprint1;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SampleDataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final SampleData sampleData;

    public SampleDataInitializer(SampleData sampleData) {
        this.sampleData = sampleData;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        sampleData.createSampleData();
    }
}