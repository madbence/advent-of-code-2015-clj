(ns aoc-15.d09
  (:require [clojure.string :refer [split-lines]]))

(defn add-edge [graph from to distance]
  (-> graph
      (assoc-in [from to] distance)
      (assoc-in [to from] distance)))

(defn parse-line [line]
  (let [[_ from to dst] (re-matches #"(\w+) to (\w+) = (\d+)" line)]
    [from to (Integer/parseInt dst)]))

(defn permutations [xs]
  (if (empty? xs)
    [[]]
    (mapcat #(map (fn [r] (conj r %)) (permutations (disj xs %))) xs)))

(defn get-route-length [graph path]
  (->> (map vector path (rest path))
       (map #(get-in graph %))
       (reduce +)))

(defn a [input]
  (let [graph (->> input
                   split-lines
                   (map parse-line)
                   (reduce #(apply add-edge %1 %2) {}))
        nodes (set (keys graph))]
    (->> nodes
         permutations
         (map #(get-route-length graph %))
         (reduce min))))

(defn b [input]
  (let [graph (->> input
                   split-lines
                   (map parse-line)
                   (reduce #(apply add-edge %1 %2) {}))
        nodes (set (keys graph))]
    (->> nodes
         permutations
         (map #(get-route-length graph %))
         (reduce max))))
