repositories.remote << 'http://www.ibiblio.org/maven2'
repositories.remote << 'http://download.java.net/maven/2'
repositories.remote << 'http://download.java.net/maven/glassfish'

#Jersey requires this pom, and transitive doesn't work, as BuildR doesn't seem to understand legacy Maven repos.
JAVA_PERSISTENCE = 'javax.persistence:persistence-api:pom:1.0.2'
download artifact(JAVA_PERSISTENCE) => 'http://download.java.net/maven/1/javax.persistence/poms/persistence-api-1.0.2.pom'

LOG4J = 'log4j:log4j:jar:1.2.16'
JERSEY = transitive('com.sun.jersey:jersey-server:jar:1.1.3-ea-SNAPSHOT')
JAVAX_ANNOTATIONS = 'javax.annotation:jsr250-api:jar:1.0'
HTTP_CLIENT = transitive('commons-httpclient:commons-httpclient:jar:3.1')
JETTY = struct(
	:server 		=> 'org.mortbay.jetty:jetty:jar:6.0.2',
	:util			=> 'jetty:jetty-util:jar:6.0.2',
	:servlet_api	=> 'jetty:servlet-api:jar:2.5-6.0.2'
)
JUNIT = 'junit:junit:jar:4.8.1'
HAMCREST = 'org.hamcrest:hamcrest-all:jar:1.1'

desc "The Restest project"

define "restest" do
  project.version = '0.1'
  compile.with JAVA_PERSISTENCE, LOG4J, JERSEY, JAVAX_ANNOTATIONS, HTTP_CLIENT, JETTY, JUNIT, HAMCREST
  package(:war)
end
