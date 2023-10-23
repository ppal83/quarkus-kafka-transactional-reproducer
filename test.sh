#!/bin/bash

for i in `seq 1 100`; do curl -X POST http://localhost:8080/api/v1/test/kafka-transactional-success; done
for i in `seq 1 100`; do curl -X POST http://localhost:8080/api/v1/test/kafka-transactional-fail1; done
for i in `seq 1 100`; do curl -X POST http://localhost:8080/api/v1/test/kafka-transactional-fail2; done
