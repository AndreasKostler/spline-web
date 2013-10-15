(ns spline-webapp.core
  (:use [compojure.route :only [files not-found]]
        [compojure.handler :only [site]] ; form, query params decode; cookie; session, etc
        [compojure.core :only [defroutes GET POST DELETE ANY context]]
        [compojure.route :as route]
        [clj-time.coerce]
        [clj-time.local]
        org.httpkit.server)
  (:gen-class))

(defn show-stats [_]
  "<h1>DUMMY STATS</h1>")

(defn store-email [{email "email" timestamp "timestamp"}]
  "OK")

(defn not-found-str [req]
  "<h1> Invalid Route </h1>")

(defroutes routes
  (POST "/foo*" {params :form-params} (store-email params))
  (GET "/stats-are-for-twats/" [] show-stats)
  (route/not-found not-found-str))

(defn -main [& port]
  (let [port (Integer/parseInt (get (System/getenv) "SPLINE_PORT" (or (first port) "8080")))]
    (run-server (site #'routes) {:port port})))
