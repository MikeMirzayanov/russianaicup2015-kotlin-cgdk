set -e

rm -rf classes
mkdir classes

kotlinc src/main/java -d classes
javac -cp "classes:$(dirname $(which kotlinc))/../lib/kotlin-runtime.jar" -sourcepath "src/main/java" -d classes "src/main/java/Runner.java" > compilation.log

if [ ! -f classes/Runner.class ]
then
    echo Unable to find classes/Runner.class >> compilation.log
    exit 1
fi

if [ ! -f classes/MyStrategy.class ]
then
    echo Unable to find classes/MyStrategy.class >> compilation.log
    exit 1
fi

jar cvfe "./kotlin-cgdk.jar" Runner -C "./classes" .
