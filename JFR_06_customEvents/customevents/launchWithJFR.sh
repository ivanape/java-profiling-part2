#! /bin/bash
mvn package
java \
  -XX:+FlightRecorder -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:FlightRecorderOptions=stackdepth=1024 \
  -XX:StartFlightRecording=settings=profile,dumponexit=true,filename="$(pwd)/customevents.jfr"\
  -jar target/customevents-1.0-SNAPSHOT.jar 