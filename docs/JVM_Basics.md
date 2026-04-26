What is JDK, JRE, JVM
# JVM (Java Virtual Machine)
JVM is the engine that runs Java programs. It takes compiled Java code (bytecode) and executes it on your system.
JVM makes Java platform independent because it runs the same bytecode on different operating systems.


# JRE (Java Runtime Environment)

JRE provides everything needed to run Java programs. It includes:
JVM (to execute code)
Libraries and supporting files

# JDK (Java Development Kit)

JDK is used to develop Java programs. It includes:

JRE (so you can run programs)
Compiler (javac) to convert code into bytecode
Development tools 


What is bytecode
Bytecode is the intermediate code generated after compiling a Java program using javac.
It is stored in .class files.
This bytecode is not machine-specific. Instead, it is executed by the JVM,
which converts it into machine code for the specific operating system.


What does “write once, run anywhere” mean (1–2 short paragraphs)
“Write Once, Run Anywhere” means that Java code can be written once and run on any system without modification.
When you compile Java code, it becomes bytecode, which is independent of any platform. Different systems
(Windows, Linux, macOS) have their own JVM, and each JVM can execute the same bytecode.

This is why Java programs do not need to be rewritten for different operating systems, making Java highly portable and widely used.