(ns third-1
  (:require [clojure.string :as cstr]))

(def rucksacks "vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw")

(defn get-val [char] (let [char-code (int char)] (if (> char-code 90) (- char-code 70) (- char-code 64))))

(get-val \a)

(defn filter-common [rucksack] (let [char-count (count rucksack)
                                     [first-compartment, second-compartment]  (split-at (/ char-count 2) rucksack)]
                                 (filter (set first-compartment) second-compartment)))

(comment (map filter-common))

 (map (comp set filter-common) (cstr/split-lines rucksacks))