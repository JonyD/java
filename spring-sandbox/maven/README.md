maven readme
https://spring.io/guides/gs/maven/#scratch


mvn compile
mvn package 
mvn install

The compile goal -> compile. creates *.class files in the target/classes.
The package goal -> compile, run tests, package in JAR file in /target.
The install goal -> compile, test, and package and then copy it into the local dependency repository, ready for another project to reference it as a dependency.
