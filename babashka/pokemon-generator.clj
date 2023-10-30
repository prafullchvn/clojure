(ns pokemon-generator
  (:require [clojure.string :refer [split-lines split]]
            [hiccup.core :as h]))

(defn parse-csv-data [file-path] (->> #"(\||\n)"
                                      (split (slurp file-path))
                                      (partition 9)
                                      (map (fn [line] (into [] line)))))

(defn pokemon-card [pokemon] (let [{id :id
                                    name :name
                                    types :types
                                    hp :hp
                                    attack :attack
                                    base_experience :base_experience
                                    defense :defense
                                    speed :speed
                                    weight :weight} pokemon]
                               [:div.pokemon-card {:id id}
                                [:div.pokemon-image
                                 [:img {:src (str "resources/images/" name ".png")}]]
                                [:div.pokemon-details
                                 [:header
                                  [:h2 name]
                                  [:div {:class (split types #",")}]]
                                 [:div.stats
                                  [:table
                                   [:tr [:th "Weight"] [:td weight]]
                                   [:tr [:th "Base XP"] [:td base_experience]]
                                   [:tr [:th "HP"] [:td hp]]
                                   [:tr [:th "Attack"] [:td attack]]
                                   [:tr [:th "Defense"] [:td defense]]
                                   [:tr [:th "Speed"] [:td speed]]]]]]))

(defn get-pokemons [csv-data]
  (let [[raw-headers, & pokemon-lists] csv-data
        headers (map keyword raw-headers)
        pokemon-details (map #(zipmap headers %) pokemon-lists)]
    pokemon-details))

(defn generate-pokemon-page [pokemon-cards] (h/html [:html
                                                     [:head [:link {:href "resources/css/pokemon.css"}]]
                                                     [:body [:div.pokemon-cards pokemon-cards]]]))

(defn generate-pokemon-cards [pokemon-data] (map pokemon-card  pokemon-data))