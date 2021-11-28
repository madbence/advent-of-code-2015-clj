(ns aoc-15.d01-test
  (:require [aoc-15.d01 :refer [a b]]
            [clojure.test :refer [deftest are]]))

(deftest test-a
  (are [input expected] (= (a input) expected)
       "(())" 0
       "()()" 0
       "(((" 3
       "(()(()(" 3
       "))(((((" 3
       "())" -1
       "))(" -1
       ")))" -3
       ")())())" -3))

(deftest test-b
  (are [input expected] (= (b input) expected)
       ")" 1
       "()())" 5))
