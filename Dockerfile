FROM tomcat:9-jdk8
COPY  target/application-javaee.war /usr/local/tomcat/webapps/ROOT.war