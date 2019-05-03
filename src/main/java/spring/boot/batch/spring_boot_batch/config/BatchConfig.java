package spring.boot.batch.spring_boot_batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.boot.batch.spring_boot_batch.tasklet.TaskletOne;
import spring.boot.batch.spring_boot_batch.tasklet.TaskletTwo;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step stepOne() {
        return stepBuilderFactory.get("stepOne").tasklet(new TaskletOne()).build();
    }

    @Bean
    public Step stepTwo() {
        return stepBuilderFactory.get("stepTwo").tasklet(new TaskletTwo()).build();
    }

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer())
                .start(stepOne())
                .next(stepTwo())
                .build();
    }

}
