(ns exchange.core
  (:require [io.pedestal.http :as server]
            [io.pedestal.http.route :as route]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.route.definition :refer [defroutes]]
            [io.pedestal.http.ring-middlewares :as ring-middlewares]
            [exchange.ui :as ui]
            [ring.util.response :as ring-resp]))

(defn hello-world
  [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (ui/render-server)})

(defroutes routes
  [[["/" {:get hello-world}]
    ["/static/*tail" {:get (ring-middlewares/resource "public")}]]])

(def service {:env :dev
              ::server/join? false
              ::server/routes routes
              ::server/resource-path "/public"
              ::server/type :jetty
              ::server/port 8080})

(defn run-dev
  "The entry-point for 'lein run-dev'"
  [& args]
  (println "\nCreating your [DEV] server...")
  (-> service
      server/default-interceptors
      server/dev-interceptors
      server/create-server
      server/start))
