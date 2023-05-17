(defn greatest-of-3 [num1 num2 num3]
  (let [max-num (max num1 num2 num3)
        min-num (min num1 num2 num3)
        sum-of-all (apply + [num1 num2 num3])]
    (- sum-of-all (+ max-num min-num))))