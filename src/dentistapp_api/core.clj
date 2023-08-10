(ns dentistapp-api.core
  (:require [compojure.core :as compojure]
            [ring.util.response :as response]
            [ring.adapter.jetty :as jetty]))

(defroutes app-routes
  (GET "/" [] "Hello, world!"))

(def app
  (-> app-routes
      (compojure/wrap-response (fn [response]
                                 (assoc response :headers {"Content-Type" "application/json"})))))

(defn -main []
  (println "Starting server on port 3000")
  (jetty/run-jetty app {:port 3000}))
