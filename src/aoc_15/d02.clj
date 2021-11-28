(ns aoc-15.d02
  (:require [clojure.string :refer [split-lines]]))

(defn area [a b] (* a b))

(defn extra [a b c]
  (let [m (max a b c)]
    (cond
      (= m a) (area b c)
      (= m b) (area a c)
      (= m c) (area a b))))

(defn box [a b c]
  (+ (* 2 (+ (area a b)
             (area a c)
             (area b c)))
     (extra a b c)))

(defn ribbon [a b c]
  (let [m (max a b c)
        extra (* a b c)
        r (cond
            (= m a) (* 2 (+ b c))
            (= m b) (* 2 (+ a c))
            (= m c) (* 2 (+ a b)))]
    (+ r extra)))

(defn parse-line [line]
  (let [[_ a b c] (re-matches #"(\d+)x(\d+)x(\d+)" line)]
    [(Integer/parseInt a)
     (Integer/parseInt b)
     (Integer/parseInt c)]))

(defn a [input]
  (->> (split-lines input)
       (map parse-line)
       (map (partial apply box))
       (reduce +)))

(defn b [input]
  (->> (split-lines input)
       (map parse-line)
       (map (partial apply ribbon))
       (reduce +)))
