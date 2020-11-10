(ns rpsls-clj.core-test
  (:require [midje.sweet :refer :all]
            [clojure.test :refer :all]
            [rpsls-clj.core :refer :all]))

(facts "Guess validation"
  (fact "returs the valid guess"
    (validate-guess "r") => "r"
    (validate-guess "p") => "p"
    (validate-guess "s") => "s")

  (fact "returs nil for invalid guess"
    (validate-guess "e") => nil
    (validate-guess "Foo") => nil))

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

(facts "About guess->string"
  (fact "changes guess chars to full strings"
    (guess->string "r") => "Rock"
    (guess->string "p") => "Paper"
    (guess->string "s") => "Scissors"))

(facts "A new game"
  (fact "starts with Y or y pressed"
    (start-new-game? "Y") => :yes
    (start-new-game? "y") => :yes)
  (fact "will not be started with N or n pressed, but will quit"
    (start-new-game? "N") => :quit
    (start-new-game? "n") => :quit)
  (fact "starts also with nil (default is (Y)es)"
    (start-new-game? nil) => :yes
    (start-new-game? "")  => :yes)
  (fact "any other value asks again"
    (start-new-game? "aaee") => :ask-again
    (start-new-game? "B")    => :ask-again
    (start-new-game? "))")   => :ask-again))
