#! /bin/bash

java \
  -XX:+FlightRecorder -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:FlightRecorderOptions=stackdepth=1024 \
  -XX:StartFlightRecording=settings=profile,dumponexit=true,filename="$(pwd)/deadLock.jfr",path-to-gc-roots=true\
  -jar target/deadLock.jar