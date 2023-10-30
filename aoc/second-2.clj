(ns user
  (:require [clojure.string :as cstr]))

(def opponent-moves-mapper {'A :rock
                            'B :paper
                            'C :scissor})

(def match-result-mapper {'X :win
                          'Y :lose
                          'Z :draw})

(def round-data "A Y
B X
C Z")

(def winning-point {:rock {:win 7
                           :lose 1
                           :draw 4}
                    :paper {:win 8
                            :lose 2
                            :draw 5}
                    :scissor {:win 9
                              :lose 3
                              :draw 6}})

(defn map-match-result [input] (map match-result-mapper (take-nth 2 (reverse input))))

(defn map-opponent-moves [input] (mapv opponent-moves-mapper (take-nth 2 input)))

(defn winning-point-mapper [[opponent-move match-result]]
  (match-result (winning-point opponent-move)))

(comment (let [input (read-string (str "[" round-data "]"))
               opponent-moves (map-opponent-moves input)
               match-result (map-match-result input)]
           (->> match-result
                (map vector opponent-moves)
                (map winning-point-mapper)
                (reduce +)
                )))