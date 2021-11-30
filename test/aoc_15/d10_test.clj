(ns aoc-15.d10-test
  (:require [clojure.test :refer [is deftest]]
            [clojure.string :refer [join]]
            [aoc-15.d10 :refer [look-and-say]]))

(deftest test-look-and-say
  (is (= (join (look-and-say "1")) "11"))
  (is (= (join (look-and-say "11")) "21"))
  (is (= (join (look-and-say "21")) "1211"))
  (is (= (join (look-and-say "1211")) "111221"))
  (is (= (join (look-and-say "111221")) "312211")))
