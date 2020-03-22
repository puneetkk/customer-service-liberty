FROM centos
RUN yum install -y java

VOLUME /tmp
ADD ./target/customerservice-0.0.1-SNAPSHOT.jar cservice.jar
ENTRYPOINT ["java","-jar","-Dserver.port=9090","/cservice.jar"]
EXPOSE 9090