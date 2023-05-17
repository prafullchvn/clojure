
(defn fun [num] (lazy-seq (list* num (fun (inc num)))))

(take 5 (fun 5))