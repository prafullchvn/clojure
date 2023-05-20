(repeat 4 2)
(#(+ % 4)  2)
(#(+ %1 %2) 5 6)
(map + (range 10))
(filter even? (range 10))
(map (juxt inc inc) (range 10))

;; mapcat takes 1st arg as function which returns list
(mapcat (juxt inc inc) (range 10))
;; following will give error since result of (comp inc inc ) will not return single value
;;(mapcat (comp inc inc) (range 10))

;; interleave takes two vector will create another vector by mixing them 
(interleave [:space :a :b] [:apple :mango :orange])

(take-last 5 (range 10))
(drop-last 5 (range 10))

(#(= (mod % 2) 0) 2)

;; it stops when predicate returns false
(take-while #(= (mod % 2) 0) (range 10))

;; it keeps value till predicate returns false
(drop-while #(= (mod %1 2) 0) (range 10))

;; gives every nth number for ex for 5 it will return 0th then 5th then 10th
(take-nth 5 (range 10))

(partition 3 (range 10))
(partition-all 3 (range 10))

(partition-by #(= (mod % 2) 0) [1 2 2 4 3 2 333 45])

(take 5 (cycle (range 3)))

(map-indexed println (range 3))