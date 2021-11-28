(ns aoc-15.d04-test
  (:require [clojure.test :refer [deftest is]]
            [aoc-15.d04 :refer [a b]]))

(deftest test-a
  (is (= (a "abcdef") 609043))
  (is (= (a "pqrstuv") 1048970)))
