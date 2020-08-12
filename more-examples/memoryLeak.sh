#!/bin/zsh
cd target/classes
java -XX:StartFlightRecording=settings=profile,dumponexit=true,filename="$(pwd)/memoryleak.jfr"\
    -Xms2G -Xmx2G org.programwar.examples.MemoryLeak