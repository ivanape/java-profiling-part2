#! /bin/bash
mvn package
java \
  -XX:+FlightRecorder -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:FlightRecorderOptions=stackdepth=1024 \
  -XX:StartFlightRecording=settings=profile,dumponexit=true,filename="$(pwd)/exceptions.jfr",path-to-gc-roots=true\
  -jar target/exceptions-1.0-SNAPSHOT.jar 