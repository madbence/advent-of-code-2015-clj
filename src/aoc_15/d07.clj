(ns aoc-15.d07
  (:require [clojure.string :refer [split-lines]]))

(defn parse-source [s]
  (if (re-matches #"\d+" s)
    {:value (Short/parseShort s)}
    {:wire s}))

(defn parse-op [s]
  (case s
    "OR" :or
    "AND" :and
    "RSHIFT" :rshift
    "LSHIFT" :lshift))

(defn ready? [conn cache]
  (and (or (some? (-> conn :op1 :value))
           (some? (get cache (-> conn :op1 :wire))))
       (or (nil? (:op2 conn))
           (some? (-> conn :op2 :value))
           (some? (get cache (-> conn :op2 :wire))))))

(defn get-value-or-wire [cache conn op]
  (if (some? (-> conn op :wire))
    (->> conn op :wire (get cache))
    (->> conn op :value)))

(defn get-result [conn cache]
  (let [op1 (get-value-or-wire cache conn :op1)
        op2 (get-value-or-wire cache conn :op2)]
    (case (:op conn)
      :id op1
      :not (bit-and 16rFFFF (bit-not op1))
      :and (bit-and op1 op2)
      :or (bit-or op1 op2)
      :rshift (bit-and 16rFFFF (bit-shift-right op1 op2))
      :lshift (bit-and 16rFFFF (bit-shift-left op1 op2)))))

(defn get-value
  ([wire conns] (get-value wire {} conns))
  ([wire cache conns]
   (loop [cache cache
          conns (set conns)]
     (if (get cache wire)
       (get cache wire)
       (let [next-ready (->> conns (filter #(ready? % cache)) first)]
         (if (some? (get cache (-> next-ready :res :wire)))
           (recur cache (disj conns next-ready))
           (recur (assoc cache (-> next-ready :res :wire) (get-result next-ready cache))
                  (disj conns next-ready))))))))

(defn parse-line [line]
  (if-let [m (re-matches #"(\w+) -> (\w+)" line)]
    {:op :id :op1 (parse-source (nth m 1)) :res (parse-source (nth m 2))}
    (if-let [m (re-matches #"NOT (\w+) -> (\w+)" line)]
      {:op :not :op1 (parse-source (nth m 1)) :res (parse-source (nth m 2))}
      (if-let [m (re-matches #"(\w+) (\w+) (\w+) -> (\w+)" line)]
        {:op (parse-op (nth m 2)) :op1 (parse-source (nth m 1)) :op2 (parse-source (nth m 3)) :res (parse-source (nth m 4))}
        nil))))

(defn a [input]
  (->> input split-lines (map parse-line) (get-value "a")))

(defn b [input]
  (let [parsed (->> input split-lines (map parse-line))
        a (get-value "a" parsed)]
    (get-value "a" {"b" a} parsed)))
