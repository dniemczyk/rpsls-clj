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
    (winner "r" "o") => 2))
