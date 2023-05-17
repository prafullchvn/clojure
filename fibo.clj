;; (defn fibo' [limit]
;;   (loop [[a b] [0 1]
;;          limit limit
;;          series []]
;;     (if (zero? limit)
;;       series
;;       (recur [b (+ a b)] (dec limit) (conj series a)))))

(defn fibo
  ([] (fibo 0 1))
  ([a b] (lazy-seq (list* a (fibo b (+ a b))))))