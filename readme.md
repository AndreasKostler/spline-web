spline-web
==========

You will need leiningen to build the uberjar:
Go to the application folder and do

> lein uberjar

You can run the bin with

> java -jar target/spline-webapp.jar

It doesn't do much yet, though.

You will also need to install nginx and copy the provided default.conf to wherever your nginx installation keeps it's config files.