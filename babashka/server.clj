(ns server
  (:require [org.httpkit.server :as server])
  (:require [pokemon-generator :as pg]))

(def pokemon-page (->> "./resources/first_10_pokemon"
                       pg/parse-csv-data
                       pg/get-pokemons
                       pg/generate-pokemon-cards
                       pg/generate-pokemon-page))

(defn handler [req] {:status 200 :body pokemon-page})
 
(def server (server/run-server handler {:port 8002}))

