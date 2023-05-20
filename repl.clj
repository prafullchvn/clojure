;; (println(eval (read-string (first *command-line-args*))))

(loop []
  (->> (read-line)
       read-string
       eval
       println)
  (recur))

