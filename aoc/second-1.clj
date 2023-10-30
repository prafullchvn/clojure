(ns user
  (:require [clojure.string :as cstr]))

(def moves {"A" :rock
            "X" :rock
            "B" :paper
            "Y" :paper
            "C" :scissor
            "Z" :scissor})

(def lose-to {:rock :paper
              :paper :scissor
              :scissor :stone})

(def move->score {:rock 1
                  :paper 2
                  :scissor 3})

(def round-data "A Y
B X
C Z")
;; ()
;; ((rock paper) (paper rock) (scissor scissor)) -> [(0 1) (6 2) (3 3)] ->

(defn round-result [move1 move2]
  (cond
    (= move1 move2) 3
    (= (lose-to move1) move2) 6
    :else 0))

(def evaluate-round (juxt
                     (partial apply move->score)
                     (partial apply round-result)))


(let [moves-played (->> #"[ \n]"
                        (cstr/split round-data)
                        (map moves)
                        (partition 2))]
  (->> moves-played
       (mapcat evaluate-round)
       (reduce +)))




(move->score :paper)