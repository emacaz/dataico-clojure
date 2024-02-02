(ns clojure-challenge.problem2
  (:require [clojure.java.io :as io]
            [clojure.data.json :as json]
            [clojure-challenge.invoice-spec :as invoice]
            [clojure.spec.alpha :as s]))

;; Function to load an invoice from a JSON file
(defn load-invoice [file-name]
  "Loads an invoice from a JSON file."
  (try
    (let [file-content (slurp file-name)]
      (json/read-str file-content))
    (catch Exception e
      (println (str "Error loading JSON file: " (.getMessage e)))
      nil)))


;; Function to validate an invoice against the ::invoice spec
(defn validate-invoice [invoice]
  "Validates an invoice against the ::invoice spec."
  (if (s/valid? ::invoice/invoice invoice)
    (println "JSON map is valid according spec.")
    (do
      (println "JSON map does not meet specs.")
      (s/explain ::invoice/invoice invoice))))

(defn -main [file-name]
  "Main entry point"
  (let [invoice (load-invoice file-name)]
    (if invoice
      (if (validate-invoice invoice)
        (do
          (println "Invoice is valid")
          (println invoice))
        (println "Invoice does not meet specs."))
      (println "Failed loading JSON file.")))
  (println "Application finished."))