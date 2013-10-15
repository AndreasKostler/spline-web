spline-web
==========

You will need [leiningen](https://github.com/technomancy/leiningen) to build the uberjar:

Go to the application folder and do

> lein uberjar

You can run the bin with

> java -jar target/spline-webapp.jar

It doesn't do much yet, though.

You will also need to install nginx and copy the provided default.conf to wherever your nginx installation keeps it's config files.

To enable the db backend, install postgres, create a user postgres, password 'spline', creat a databse named spline, and make sure you adjust pg_hbe.conf accordingly. There is a sql file in the sql folder - run it. 
