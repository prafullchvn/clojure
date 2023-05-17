(defn gcd [num-1 num-2]
  (loop [a num-1
         b num-2
         c (max  num-1 num-2)]
    (if (and (= (mod a c) 0) (= (mod b c) 0))
      c
      (recur a
             b
             (dec c)))))