(ns aoc-15.d08
  (:require [clojure.string :refer [split-lines starts-with?]]))

(defn count-parsed [s]
  (cond
    (empty? s) 0
    (and (= \\ (first s)) (= \x (second s))) (inc (count-parsed (drop 4 s)))
    (= \\ (first s)) (inc (count-parsed (drop 2 s)))
    (= \" (first s)) (count-parsed (drop 1 s))
    :else (inc (count-parsed (drop 1 s)))))

(defn count-encoded [s]
  (cond
    (empty? s) 0
    (= \" (first s)) (+ 2 (count-encoded (drop 1 s)))
    (= \\ (first s)) (+ 2 (count-encoded (drop 1 s)))
    :else (inc (count-encoded (drop 1 s)))))

(defn a [input]
  (let [lines (split-lines input)]
    (- (->> lines (map count) (reduce +))
       (->> lines (map count-parsed) (reduce +)))))

(defn b [input]
  (let [lines (split-lines input)]
    (- (->> lines (map #(+ 2 (count-encoded %))) (reduce +))
       (->> lines (map count) (reduce +)))))
