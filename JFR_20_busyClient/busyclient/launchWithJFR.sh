#! /bin/bash
mvn package
java \
  -XX:+FlightRecorder -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:FlightRecorderOptions=stackdepth=1024 \
  -XX:StartFlightRecording=settings=profile,dumponexit=true,filename="$(pwd)/busyclient.jfr"\
  -jar target/busyclient-1.0-SNAPSHOT.jar 