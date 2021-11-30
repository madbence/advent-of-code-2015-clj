(ns aoc-15.d08-test
  (:require [aoc-15.d08 :refer [count-parsed a b]]
            [clojure.test :refer [is deftest]]))

(deftest test-count-parsed
  (is (= (count-parsed "\"\"") 0))
  (is (= (count-parsed "\"abc\"") 3))
  (is (= (count-parsed "\"aaa\\\"aaa\"") 7))
  (is (= (count-parsed "\"\\x27\"") 1)))

(def fixture
  "\"\"
\"abc\"
\"aaa\\\"aaa\"
\"\\x27\"")

(deftest test-a
  (is (= (a fixture) 12)))

(deftest test-b
  (is (= (b fixture) 19)))
