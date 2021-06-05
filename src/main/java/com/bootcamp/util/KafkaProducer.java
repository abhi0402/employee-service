package com.bootcamp.util;

import com.bootcamp.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaSender<Integer, String> kafkaSender;

    @Value("${kafka.employee.topic}")
    String topicName;

    public void produceEmpMessage(EmployeeDto employeeDto) {
        SenderRecord<Integer, String, Integer> senderRecord =
                SenderRecord.create(new ProducerRecord<>(topicName, employeeDto.getId(), Mapper.mapEmpToString(employeeDto)), employeeDto.getId());
        kafkaSender.send(Mono.just(senderRecord))
                .doOnError(e -> log.error("Error occurred in producing kafka message => " + e.getMessage()))
                .doOnNext(e -> log.info("Kafka message produced successfully => " + e.recordMetadata()))
                .subscribe();
    }

}
