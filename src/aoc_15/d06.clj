(ns aoc-15.d06
  (:require [clojure.string :refer [split-lines]]))

(defn update-cell [grid coord action]
  (case action
    :turn-on (assoc grid coord true)
    :turn-off (assoc grid coord false)
    :toggle (update grid coord not)))

(defn update-cell' [grid coord action]
  (case action
    :turn-on (update grid coord inc)
    :turn-off (assoc grid coord (max 0 (dec (get grid coord 0))))
    :toggle (update grid coord #(+ 2 %))))

(defn update-region [updater grid x1 y1 x2 y2 action]
  (->> (for [x (range x1 (inc x2)) y (range y1 (inc y2))] {:x x :y y})
       (reduce #(updater %1 %2 action) grid)))

(defn parse-line [line]
  (let [m (re-matches #"(turn on|turn off|toggle) (\d+),(\d+) through (\d+),(\d+)" line)]
    [(Integer/parseInt (nth m 2))
     (Integer/parseInt (nth m 3))
     (Integer/parseInt (nth m 4))
     (Integer/parseInt (nth m 5))
     (case (nth m 1)
       "turn on" :turn-on
       "turn off" :turn-off
       "toggle" :toggle)]))

(def grid (update-region update-cell {} 0 0 999 999 :turn-off))
(def grid' (update-region update-cell' {} 0 0 999 999 :turn-off))

(defn a [input]
  (->> input
       split-lines
       (map parse-line)
       (reduce (partial apply update-region update-cell) grid)
       (filter second)
       count))

(defn b [input]
  (->> input
       split-lines
       (map parse-line)
       (reduce (partial apply update-region update-cell') grid')
       (map second)
       (reduce +)))
