find . -type f -name "*.class" -exec rm {}  \;    #remove classfiles
find . -name "*.java" | xargs javac -cp "../lib/*" #build classes
java -jar ../lib/junit-platform-console-standalone-1.8.1.jar --classpath . --fail-if-no-tests --include-engine=junit-jupiter --include-classname='.*Test.*' --scan-classpath --reports-dir=reports 2>/dev/null | grep -wv "Thanks"
find . -type f -name "*.class" -exec rm {}  \;    #remove classfiles