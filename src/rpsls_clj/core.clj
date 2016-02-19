;;;; Rock Paper Scissors Lizzard Spock Game
;;;; --------------------------------------
;;;;
;;;; A simple Clojure implementation of the famous game
;;;; of hand-waving combat
(ns rpsls-clj.core
  (:gen-class))

;;; Any of the two players can choose one of the 5 options
;;; "r" for (r)ock, "p" for (p)aper, "s" for (s)cissors,
;;; "l" for (l)izzard, "o" for Sp(o)ck

(defn winner
  "Defines the wining guess
   Returns 1 if the 1st guess wins, 2 if the 2nd one wins
   and 0 in case of a draw"
  [guess1 guess2]
  (let [guesses [guess1 guess2]
        winner-map {["r" "p"] 2 ["r" "s"] 1 ["r" "l"] 1 ["r" "o"] 2
                    ["p" "r"] 1 ["p" "s"] 2 ["p" "l"] 2 ["p" "o"] 1}]
    (if (= guess1 guess2) 0 (get winner-map guesses))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
