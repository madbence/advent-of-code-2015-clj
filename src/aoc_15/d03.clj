(ns aoc-15.d03)

(defn move [curr dir]
  (case dir
    \> (update curr :x inc)
    \< (update curr :x dec)
    \^ (update curr :y inc)
    \v (update curr :y dec)))

(defn a [input]
  (->> input
       (reductions move {:x 0 :y 0})
       set
       count))

(defn b [input]
  (let [input' (partition 2 input)
        santa (map first input')
        robo-santa (map second input')
        houses (reductions move {:x 0 :y 0} santa)
        robo-houses (reductions move {:x 0 :y 0} robo-santa)]
    (->> (concat houses robo-houses)
         set
         count)))
