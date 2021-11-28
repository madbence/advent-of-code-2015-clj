(ns aoc-15.d06-test
  (:require [clojure.test :refer [deftest is]]
            [aoc-15.d06 :refer [a b]]))

(deftest test-a
  (is (= (a "turn on 0,0 through 999,999") 1000000))
  (is (= (a "toggle 0,0 through 999,0") 1000))
  (is (= (a "turn on 499,499 through 500,500") 4)))

(deftest test-b
  (is (= (b "turn on 0,0 through 0,0") 1))
  (is (= (b "toggle 0,0 through 999,999") 2000000)))
