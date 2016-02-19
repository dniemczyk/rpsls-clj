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
  (let [guesses [guess1 guess2]]
    (cond
      (= guesses ["r" "r"]) 0
      (= guesses ["r" "p"]) 2
      (= guesses ["r" "s"]) 1
      (= guesses ["r" "l"]) 1
      (= guesses ["r" "o"]) 2)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
