package spring.boot.batch.spring_boot_batch.tasklet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

@Slf4j
public class TaskletOne implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("TaskletOne is going to be executed");
        //TODO your code here
        log.info("TaskletOne is finished");
        return RepeatStatus.FINISHED;
    }

}
