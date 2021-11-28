(ns aoc-15.d02-test
  (:require [clojure.test :refer [is deftest]]
            [aoc-15.d02 :refer [box ribbon]]))

(deftest test-box
  (is (= (box 2 3 4) 58))
  (is (= (box 1 1 10) 43)))

(deftest test-ribbon
  (is (= (ribbon 2 3 4) 34))
  (is (= (ribbon 1 1 10) 14)))
