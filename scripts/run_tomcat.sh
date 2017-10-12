#!/bin/bash

while [ ! -f /src/target/Sheridan_Jeopardy-1.0-SNAPSHOT.war ]
do
  echo "---------------------------------------------------------"
  echo "Waiting for Maven to finish building project"
  echo "---------------------------------------------------------"
  sleep 2
done

# Do not change name for final file, or the game won't wprk.
# This is because that would also change the internally used URL of game.
cp -r /src/target/Sheridan_Jeopardy-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/jeopardy.war


echo "---------------------------------------------------------"
echo "Project deployment complete!"
echo "---------------------------------------------------------"

catalina.sh run
