(require '[hiccup.core :as h])

(h/html [:head [:script {"src" "some-js-file.js"}][:body.soem.thing]])

(def names ["abc" "xyz" "def"])

(defn name-elem [name] [[:p {:style {:color "red"}} name :p "something"]])

(h/html (map name-elem names))


