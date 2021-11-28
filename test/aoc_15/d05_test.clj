(ns aoc-15.d05-test
  (:require [clojure.test :refer [deftest is]]
            [aoc-15.d05 :refer [is-nice? is-nicer?]]))

(deftest test-is-nice
  (is (is-nice? "ugknbfddgicrmopn"))
  (is (is-nice? "aaa"))
  (is (not (is-nice? "jchzalrnumimnmhp")))
  (is (not (is-nice? "haegwjzuvuyypxyu")))
  (is (not (is-nice? "dvszwmarrgswjxmb"))))

(deftest test-is-nicer
  (is (is-nicer? "qjhvhtzxzqqjkmpb"))
  (is (is-nicer? "xxyxx"))
  (is (not (is-nicer? "uurcxstgmygtbstg")))
  (is (not (is-nicer? "ieodomkazucvgmuy"))))
