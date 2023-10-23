package org.acme.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.acme.service.TestService;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Slf4j
@ApplicationScoped
@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestController {

    @Inject
    TestService testService;

    @POST
    @Path("/test/kafka-transactional-success")
    @Operation(summary = "Test method to test kafka-transactional success behaviour.")
    public void testKafkaTransactionalSuccess() {
        log.info("testKafkaTransactionalSuccess");
        testService.testKafkaTransactionalSuccess();
    }

    @POST
    @Path("/test/kafka-transactional-fail1")
    @Operation(summary = "Test method to test kafka-transactional fail1 behaviour.")
    public void testKafkaTransactionalFail1() {
        log.info("testKafkaTransactionalFail1");
        testService.testKafkaTransactionalFailure1();
    }

    @POST
    @Path("/test/kafka-transactional-fail2")
    @Operation(summary = "Test method to test kafka-transactional fail2 behaviour.")
    public void testKafkaTransactionalFail2() {
        log.info("testKafkaTransactionalFail2");
        testService.testKafkaTransactionalFailure2();
    }

}
