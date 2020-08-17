#! /bin/bash
javac StringBuilderTest.java 
java \
  -XX:+FlightRecorder -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:FlightRecorderOptions=stackdepth=1024 \
  -XX:StartFlightRecording=settings=profile,dumponexit=true,filename="$(pwd)/stringBuilderTest.jfr",path-to-gc-roots=true\
  StringBuilderTest