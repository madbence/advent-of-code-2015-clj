(ns aoc-15.d01)

(defn move [curr c]
  (case c
    \( (inc curr)
    \) (dec curr)
    curr))

(defn a [input]
  (reduce move 0 input))

(defn b [input]
  (let [len (count input)
        r (reductions move 0 input)
        rest' (drop-while (comp not neg?) r)]
    (inc (- len (count rest')))))
