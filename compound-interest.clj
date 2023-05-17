(defn pow
  [number power]
  (loop [ans 1
         power power]
    (if (<= power 0)
      ans
      (recur (* ans number) (dec power)))))

(defn pow [num power]
  (apply * (repeat power num)))

(defn compound-interest [principal rate time compound-frequency]
  (* principal
     (pow
      (+ 1 (/ rate compound-frequency))
      (* time compound-frequency))))