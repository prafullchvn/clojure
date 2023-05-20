(defn my-map [func elements]
  (iterate func elements))

(defn sqr [x] (* x x))
(defn cube [x] (* x x x))
((comp sqr cube identity) 2)
((juxt sqr cube identity) 2)

(sqr 2)

(iterate inc 2)
(take 5 (remove even? (iterate inc 2)))
(take 5 (take-while (fn true) (iterate inc 2)))
(->> 2
     (iterate inc)
     (take-while (fn true))
     (take 5))