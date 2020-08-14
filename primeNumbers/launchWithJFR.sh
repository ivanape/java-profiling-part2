#! /bin/bash

java \
  -XX:+FlightRecorder -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:FlightRecorderOptions=stackdepth=1024 \
  -XX:StartFlightRecording=settings=profile,dumponexit=true,filename="$(pwd)/primeNumbers.jfr" path-to-gc-roots=true\
  -jar target/primeNumbers.jar 80000