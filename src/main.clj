(ns main
  (:require [clojure-challenge.problem1 :as problem1]
            [clojure-challenge.problem2 :as problem2]
            [clojure-challenge.problem3 :as problem3]
            [clojure.tools.logging :as log]))


(defn -main []
  "Main function to run solutions for the problems.
   It executes each problem's main function sequentially."
  (try
    (log/info "RUNNING PROBLEM 1:")
    (problem1/-main)
    (log/info "\n\nRUNNING PROBLEM 2:")
    (problem2/-main "resources/invoice.json")
    (log/info "\n\nPROBLEM 3 - RUNNING TESTS:")
    (problem3/execute-tests)
    (catch Exception e
      (log/error "An error occurred: " (.getMessage e)))))
