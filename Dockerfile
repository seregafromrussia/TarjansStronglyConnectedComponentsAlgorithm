# usb not work on Windows host, see https://github.com/docker/for-win/issues/1018

FROM openjdk:8-jdk-alpine


#ADD lib/linux /usr/lib
#ADD install-libs.sh /docker-entrypoint.d/
#
#RUN \
#    chmod +x /docker-entrypoint.d/install-libs.sh \
#    && /docker-entrypoint.d/install-libs.sh
#
#ADD 99-tty.rules /etc/udev/rules.d/
#RUN adduser root dialout
#
#ARG jar_file
#ENV JAR_FILE=$jar_file
#ADD $jar_file /app/$jar_file
#ENV EXT_JAVA_PROPS ""

#ENTRYPOINT java $EXT_JAVA_PROPS -jar /app/$JAR_FILE
