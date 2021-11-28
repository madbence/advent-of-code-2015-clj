(ns aoc-15.d03-test
  (:require [clojure.test :refer [deftest is]]
            [aoc-15.d03 :refer [a b]]))

(deftest test-a
  (is (= (a ">") 2))
  (is (= (a "^>v<") 4))
  (is (= (a "^v^v^v^v^v") 2)))

(deftest test-b
  (is (= (b "^v") 3))
  (is (= (b "^>v<") 3))
  (is (= (b "^v^v^v^v^v") 11)))
