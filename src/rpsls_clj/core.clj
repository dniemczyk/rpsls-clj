;;;; Rock Paper Scissors Lizzard Spock Game
;;;; --------------------------------------
;;;;
;;;; A simple Clojure implementation of the famous game
;;;; of hand-waving combat
(ns rpsls-clj.core
  (:gen-class))

;;; Returns one of the 5 options for the player choice:
;;; "r" for (r)ock, "p" for (p)aper, "s" for (s)cissors,
;;; "l" for (l)izzard, "o" for Sp(o)ck or nil if the
;;; guess is invalid
(defn validate-guess [guess]
  (if (#{"r" "p" "s" "l" "o"} guess) guess))

(defn get-guess []
  (println "Play your hand: (r)ock, (p)aper, (s)cissors, (l)izzard, Sp(o)ck")
  (let [guess (read-line)]
    (validate-guess guess)))

(defn winner
  "Defines the wining guess
   Returns 1 if the 1st guess wins, 2 if the 2nd one wins
   and 0 in case of a draw"
  [guess1 guess2]
  (let [guesses [guess1 guess2]
        winner-map {["r" "p"] 2 ["r" "s"] 1 ["r" "l"] 1 ["r" "o"] 2
                    ["p" "r"] 1 ["p" "s"] 2 ["p" "l"] 2 ["p" "o"] 1
                    ["s" "p"] 1 ["s" "r"] 2 ["s" "l"] 1 ["s" "o"] 2
                    ["l" "r"] 2 ["l" "p"] 1 ["l" "s"] 2 ["l" "o"] 1
                    ["o" "r"] 1 ["o" "p"] 2 ["o" "s"] 1 ["o" "l"] 2}]
    (if (= guess1 guess2) 0 (get winner-map guesses))))

(defn play-hand []
  (let [player-guess (get-guess)
        computer-guess (rand-nth ["r" "p" "s" "l" "s"])
        winner (winner player-guess computer-guess)]
    (println "The computer guessed: " computer-guess)
    (println "You guessed: " player-guess)
    (cond
      (nil? player-guess) (println "Your entry was invalid...")
      (= winner 0) (println "It is a draw.")
      (= winner 1) (println "You win!")
      (= winner 2) (println "Computer wins."))))

(defn new-game? []
  (println "Do you want to play one more game [Y/n]")
  (let [response (read-line)]
    (if (#{"Y" "y"} response) true)))

(defn -main
  "Plays the game or Rock, Paper, Scissors, Lizzard, Spock."
  [& args]
  (loop []
    (play-hand)
    (if (new-game?) (recur))))
