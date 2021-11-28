(ns aoc-15.d05
  (:require [clojure.string :refer [includes? split-lines join]]))

(defn has-3-vowels? [s]
  (-> (filter #{\a \e \i \o \u} s)
      count
      (>= 3)))

(defn has-double-letter? [s]
  (->> (map vector s (rest s))
       (some (partial apply =))))

(defn has-no-forbidden-strings? [s]
  (not (or (includes? s "ab")
           (includes? s "cd")
           (includes? s "pq")
           (includes? s "xy"))))

(defn is-nice? [s]
  (and (has-3-vowels? s)
       (has-double-letter? s)
       (has-no-forbidden-strings? s)))

(defn has-symmetric-triplet? [s]
  (->> (map vector s (drop 2 s))
       (some (partial apply =))))

(defn has-tuple-twice? [s]
  (->> s (iterate next) (take-while some?) (map #(split-at 2 %)) (some #(includes? (join (second %)) (join (first %))))))

(defn is-nicer? [s]
  (and (has-symmetric-triplet? s)
       (has-tuple-twice? s)))

(defn a [input]
  (->> input split-lines (filter is-nice?) count))

(defn b [input]
  (->> input split-lines (filter is-nicer?) count))
