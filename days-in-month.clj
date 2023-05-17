(def thirty-days-month #{:apr  :jun :jul  :sept  :nov})
(def thirty-one-days-month #{:jan :mar :may :aug :oct :dec})

(let [month :jan]
  (case month
    :jan 31
    :mar 31
    :apr 30
    :may 31
    :jun 30
    :jul 30
    :aug 31
    :sept 30
    :oct 31
    :nov 30
    :dec 31
    28
    :error))

(let [month :jan]
  (cond
    (thirty-days-month month) 30
    (thirty-one-days-month month) 31
    :else 28))

;; (def person {:name "abc"})
;; (let [name (person :name)])

;; (def arr [1 2 3 4])
;; (let [[a b & c] arr] c)

(let [month :jan]
  (condp = month
    :jan 31
    :mar 31
    :apr 30
    :may 31
    :jun 30
    :jul 30
    :aug 31
    :sept 30
    :oct 31
    :nov 30
    :dec31
    :else :error))

