(require '[babashka.cli :as cli])

(def coerce-options {:coerce {:force :boolean}})

(println (cli/parse-opts *command-line-args* coerce-options))