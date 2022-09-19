FROM ubuntu:16.04
RUN apt-get update
RUN apt-get update && apt-get install -y \
    default-jre \
    default-jdk \
    git \
    maven

RUN mvn -version
RUN git clone https://github.com/roushan303/RestAssuredMavenTestngScratch.git
CMD ls
CMD ls
RUN cd RestAssuredMavenTestngScratch && mvn test
