(ns rpsls-clj.core-test
  (:require [midje.sweet :refer :all]
            [clojure.test :refer :all]
            [rpsls-clj.core :refer :all]))

(facts "Winner is determined correctly"
  (fact "for the first player playing rock"
    (winner "r" "r") => 0
    (winner "r" "p") => 2
    (winner "r" "s") => 1
    (winner "r" "l") => 1
    (winner "r" "o") => 2)
  (fact "for the first player playing paper"
    (winner "p" "r") => 1
    (winner "p" "p") => 0
    (winner "p" "s") => 2
    (winner "p" "l") => 2
    (winner "p" "o") => 1))
