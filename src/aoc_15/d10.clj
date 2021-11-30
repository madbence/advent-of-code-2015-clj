(ns aoc-15.d10)

(defn look-and-say [s]
  (->> s
       (partition-by identity)
       (mapcat #(str (count %) (first %)))))

(defn a [input]
  (->> input
       (iterate look-and-say)
       (drop 40)
       first
       count))

(defn b [input]
  (->> input
       (iterate look-and-say)
       (drop 50)
       first
       count))
