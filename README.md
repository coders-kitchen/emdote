emdote
======

Example of using Docker for starting a container with a postgresql database for unit tests and using this container in a test.

Requirements
------------

* Docker 0.9+
* Docker image for postgres (tagged as eg_postgresql)
* Docker has enabled http access besides socks

Usage
-----

  Linux : ``./gradlew test``
  
Windows : ``gradlew.bat test``
