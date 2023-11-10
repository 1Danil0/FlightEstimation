FROM openjdk:latest
COPY /java/* /projectFlights
WORKDIR /projectFlights
EXPOSE 80
RUN javac Flightestimation.java
CMD [ "java", "FlightestimationApplication" ]

