(ns spline-webapp.core
  (:use [compojure.route :only [files not-found]]
        [compojure.handler :only [site]] ; form, query params decode; cookie; session, etc
        [compojure.core :only [defroutes GET POST]]
        [compojure.route :as route]
        [korma.db :as db]
        korma.core
        [org.httpkit.server :as server])
  (:gen-class))

(def spline-db-spec (postgres {:db "spline" :user "postgres" :password "spline"}))

(defentity users)

(defn show-stats [_]
  "<h1>DUMMY STATS</h1>")

(defn store-email [{email "email" timestamp "timestamp"}]
  (try
    (db/with-db spline-db-spec
      (insert users (values {:timestamp (read-string timestamp) :email email})))
    (catch Exception e (not-found (str e)))))

(defn not-found-str [req]
  "<h1> Invalid Route </h1>")

(defroutes routes
  (POST "/foo*" {params :form-params} (store-email params))
  (GET "/stats-are-for-twats/" [] show-stats)
  (route/not-found not-found-str))

(defn -main [& port]
  (let [port (Integer/parseInt (get (System/getenv) "SPLINE_PORT" (or (first port) "8080")))]
    (server/run-server (site #'routes) {:port port})))
