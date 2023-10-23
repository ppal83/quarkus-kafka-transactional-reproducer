package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.entity.TestEntity;
import org.acme.kafka.KafkaTestProducer;

import java.util.UUID;

@ApplicationScoped
public class TestService {

    @Inject
    KafkaTestProducer testKafkaTestProducer;

    @Transactional
    public void testKafkaTransactionalSuccess() {
        final TestEntity testEntity = new TestEntity().setName("test");
        testEntity.persist();
        testKafkaTestProducer.produce(testEntity.getId());
    }

    @Transactional
    public void testKafkaTransactionalFailure1() {
        final TestEntity testEntity = new TestEntity().setName("test1");
        testEntity.persistAndFlush();
        testKafkaTestProducer.produce(testEntity.getId());
    }

    @Transactional
    public void testKafkaTransactionalFailure2() {
        TestEntity.update("name = 'tst' where name = ?1", "test2");
        testKafkaTestProducer.produce(UUID.randomUUID());
    }

}
