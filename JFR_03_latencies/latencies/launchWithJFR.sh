#! /bin/bash
mvn package
# Oracle JDK 8 is mandatory!
/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/bin/java \
  -XX:+UnlockCommercialFeatures -XX:+FlightRecorder -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:FlightRecorderOptions=stackdepth=1024 \
  -XX:StartFlightRecording=settings=profile,dumponexit=true,filename="$(pwd)/latencies.jfr"\
  -jar target/latencies-1.0-SNAPSHOT.jar 