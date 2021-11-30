(ns aoc-15.d09-test
  (:require [aoc-15.d09 :refer [a b]]
            [clojure.test :refer [deftest is]]))

(def fixture
  "London to Dublin = 464
London to Belfast = 518
Dublin to Belfast = 141")

(deftest test-a
  (is (= (a fixture) 605)))

(deftest test-b
  (is (= (b fixture) 982)))
