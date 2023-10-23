package org.acme.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.UUID;

@ApplicationScoped
public class KafkaTestProducer {

    @Inject
    @Channel("test")
    Emitter<UUID> emitter;

    public void produce(UUID merchantId) {
        emitter.send(merchantId).toCompletableFuture().join();
    }
}
