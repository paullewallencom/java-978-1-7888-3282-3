import java.util.concurrent.*
import java.util.stream.*
import java.util.*


void print2Console(String thetext) {
	System.out.println(thetext);
	System.out.println("");
}

void runSomeProcess(String... args) throws Exception {
 String theProcess = Arrays.asList(args).stream().collect(Collectors.joining(" "));
 print2Console("You asked me to run: '"+theProcess+"'");
 print2Console("");
 ProcessBuilder compileBuilder = new ProcessBuilder(args).inheritIO();
 Process compileProc = compileBuilder.start();
 CompletableFuture<Process> compileTask = compileProc.onExit();
 compileTask.get();
}

print2Console("JShell session launched.")
print2Console("Preparing to compile Sample.java. . . ")

// run the Java Compiler to complete Sample.java
runSomeProcess("javac", "Sample.java")
print2Console("Compilation complete.")
print2Console("Preparing to run Sample.class...")

// run the Sample.class file
runSomeProcess("java", "Sample")
print2Console("Run Cycle compete.")

// exit JShell
print2Console("JShell Termination in progress...)
print2Console("Session ended.")

/exit

