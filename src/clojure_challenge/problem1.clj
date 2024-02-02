(ns clojure-challenge.problem1)

(defn has-iva-19%? [item]
  "Check if an item has :iva 19% tax rate.
  Returns false if item is not in expected format or doesn't contain the key :taxable/taxes."
  (if (and (map? item) (:taxable/taxes item))
    (some #(and (= (:tax/category %) :iva)
                (= (:tax/rate %) 19))
          (:taxable/taxes item))
    false))


(defn has-ret-fuente-1%? [item]
  "Check if an item has retention :ret_fuente 1%.
   Returns false if item is not in expected format or doesn't contain the key :retentionable/retentions."
  (if (and (map? item) (:retentionable/retentions item))
    (some #(and (= (:retention/category %) :ret_fuente)
                (= (:retention/rate %) 1))
          (:retentionable/retentions item))
    false))

(defn filter-invoice-items [invoice]
  "Filter invoice items based on the conditions.
  Returns a sequence of items that satisfy the conditions.
  Throws an exception if the invoice format is invalid or if required fields are missing."
  (if (and (map? invoice) (:invoice/items invoice))
    (->> invoice
         :invoice/items
         (filter #(or (has-iva-19%? %)
                      (has-ret-fuente-1%? %))))
    (throw (IllegalArgumentException. "Invalid invoice format or missing :invoice/items"))))

;; Usage example:
(defn -main []
  (let [invoice (clojure.edn/read-string (slurp "resources/invoice.edn"))
        filtered-items (filter-invoice-items invoice)]
    ;; Add any code here to work with filtered-items, e.g., print them
    (println "Filtered Invoice Items:" filtered-items)))
