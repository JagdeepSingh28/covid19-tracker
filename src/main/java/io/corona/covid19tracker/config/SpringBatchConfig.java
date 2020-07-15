package io.corona.covid19tracker.config;

import io.corona.covid19tracker.listeners.JobCompletionListener;
import io.corona.covid19tracker.models.LocationStats;
import io.corona.covid19tracker.services.CoronaVirusDataService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class SpringBatchConfig {

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<LocationStats> itemReader,
                   ItemProcessor<LocationStats, LocationStats> itemProcessor,
                   ItemWriter<LocationStats> itemWriter){

        Step step = stepBuilderFactory.get("orderStep1")
                .<LocationStats, LocationStats>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        return jobBuilderFactory.get("processJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .start(step)
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobCompletionListener();
    }

//    @Bean
//    public FlatFileItemReader<LocationStats> itemReader() {
//
//        FlatFileItemReader<LocationStats> flatFileItemReader = new FlatFileItemReader<>();
//        flatFileItemReader.setResource(new FileSystemResource("src/main/resources/users.csv"));
//        flatFileItemReader.setName("CSV-Reader");
//        flatFileItemReader.setLinesToSkip(1);
//        flatFileItemReader.setLineMapper(lineMapper());
//        return flatFileItemReader;
//    }
//
//    @Bean
//    public LineMapper<LocationStats> lineMapper() {
//
//        DefaultLineMapper<LocationStats> defaultLineMapper = new DefaultLineMapper<>();
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//
//        lineTokenizer.setDelimiter(",");
//        lineTokenizer.setStrict(false);
//        lineTokenizer.setNames(new String[]{"id", "name", "dept", "salary"});
//
//        BeanWrapperFieldSetMapper<LocationStats> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
//        fieldSetMapper.setTargetType(LocationStats.class);
//
//        defaultLineMapper.setLineTokenizer(lineTokenizer);
//        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
//
//        return defaultLineMapper;
//    }
}
