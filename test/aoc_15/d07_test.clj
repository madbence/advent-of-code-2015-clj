(ns aoc-15.d07-test
  (:require [clojure.test :refer [deftest is]]
            [clojure.string :refer [split-lines]]
            [aoc-15.d07 :refer [a b parse-line get-value]]))

(def fixture
  "123 -> x
456 -> y
x AND y -> d
x OR y -> e
x LSHIFT 2 -> f
y RSHIFT 2 -> g
NOT x -> h
NOT y -> i")

(deftest test-fixture
  (let [conns (->> fixture split-lines (map parse-line))]
    (is (= (get-value "d" conns) 72))
    (is (= (get-value "e" conns) 507))
    (is (= (get-value "f" conns) 492))
    (is (= (get-value "g" conns) 114))
    (is (= (get-value "h" conns) 65412))
    (is (= (get-value "i" conns) 65079))
    (is (= (get-value "x" conns) 123))
    (is (= (get-value "y" conns) 456))
    (is (= (get-value "h" {"x" 456} conns) 65079))))
