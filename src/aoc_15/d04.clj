(ns aoc-15.d04
  (:require [clojure.string :refer [starts-with?]])
  (:import java.security.MessageDigest))

(defn md5 [^String s]
  (let [algorithm (MessageDigest/getInstance "MD5")
        raw (.digest algorithm (.getBytes s))]
    (format "%032x" (BigInteger. 1 raw))))

(defn a [input]
  (->> (iterate inc 0)
       (map #(md5 (str input %)))
       (take-while #(not (starts-with? % "00000")))
       count))

(defn b [input]
  (->> (iterate inc 0)
       (map #(md5 (str input %)))
       (take-while #(not (starts-with? % "000000")))
       count))
