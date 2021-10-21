find . -name "*.java" | xargs javac -cp "../lib/*"
java -jar ../lib/junit-platform-console-standalone-1.8.1.jar --classpath . --fail-if-no-tests --include-engine=junit-jupiter --include-classname='.*Test.*' --scan-classpath --reports-dir=reports
