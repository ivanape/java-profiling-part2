#!/bin/sh
cd target/classes
java -XX:+FlightRecorder -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:FlightRecorderOptions=stackdepth=1024\
    -XX:StartFlightRecording=settings=profile,dumponexit=true,filename="$(pwd)/memoryleak.jfr",path-to-gc-roots=true\
    -Xms2G -Xmx2G org.programwar.examples.MemoryLeak