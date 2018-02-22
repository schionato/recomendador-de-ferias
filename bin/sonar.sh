#!/bin/bash
./gradlew test jacocoTestReport
./gradlew sonarqube -Dsonar.host.url=http://localhost:9000  -Dsonar.login=f6be42970870d8f7fead2c508b0c73c31f22af3b
