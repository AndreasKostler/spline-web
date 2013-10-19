(defproject spline-webapp "0.1.0"
  :description "webapp to capture emails"
  :url "http://withflare.io"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.0"]
                 [http-kit "2.1.12"]
                 [compojure "1.1.5"]
                 [korma "0.3.0-RC6"]
                 [org.postgresql/postgresql "9.2-1003-jdbc4"]]
  :uberjar-name "spline-webapp.jar"
  :main spline-webapp.core
  :profiles {:uberjar {:aot :all}})

