;; 1. infix (+ 1 2 -> 1 + 2), prefix(1 + 2 -> + 1 2), postfix
;; 2. and, or
;; 2. debug macro
;; 3. defn

(defmacro prefix->infix [form]
  `(~(second form) ~(first form) ~(last form)))

(macroexpand '(prefix->infix (+ 2 3)))

(defmacro infix->prefix [form]
  `(~(second form) ~(first form) ~(last form)))

(infix->prefix (2 + 3))

(defmacro infix->postfix [form]
  `(~(last form) ~(first form) ~(second form)))

(macroexpand '(infix->postfix (2 + 3)))


(defmacro and [p1? p2?]
  `(if ~p1? ~p2? ~p1?))

(macroexpand `(and 3 2))
(and 2 false)

(defmacro or [p1? p2?]
  `(if ~p1? ~p1? ~p2?))

(or false 2)


(defmacro debug [form]
  `(let [result# ~form] result#))

(macroexpand (debug '(+ 2 3)))


(defmacro debug' [form]
  `(let [result# ~form] (println ~(str form) " : "  result#) result#))

(macroexpand (debug' `(+ 2 3)))

(debug' (+ 2 3))

;; (defn fnName [] ())
(defmacro defn' [fn-name args body]
  `(def ~fn-name (fn ~args ~body)))

(macroexpand '(defn' add [a b] (+ a b)))

((defn' add [a b] (+ a b)) 2 3)

(defmacro when [pred? body]
  `(if ~pred? ~body))

(macroexpand `(when (> 2 3) true))

