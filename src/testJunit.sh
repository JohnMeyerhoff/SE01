find . -type f -name "*.class" -exec rm {}  \;    #remove classfiles
time (find . -name "*.java" | xargs javac -cp "../lib/*") #build classes
echo "Java build time"

time (java -jar ../lib/junit-platform-console-standalone-1.8.1.jar --classpath . --fail-if-no-tests --include-engine=junit-jupiter --include-classname='.*Test.*' --scan-classpath --reports-dir=reports 2>/dev/null | grep -wv "Thanks")
echo "JUnit run-all time"
find . -type f -name "*.class" -exec rm {}  \;    #remove classfiles