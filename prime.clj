(def (comp
  not
  (partial some zero?)
  (partial apply map rem)
  (juxt repeat (partial range 2))))

