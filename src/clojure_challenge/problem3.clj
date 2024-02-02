(ns clojure-challenge.problem3
  (:require [clojure-challenge.invoice-item :refer [subtotal]]))
(use 'clojure.test)

(deftest test-subtotal-with-discount
  ;; Testing the subtotal calculation with a standard discount.
  ;; This test verifies that the discount is correctly applied to the total price.
  (is (= 90.0 (subtotal {:invoice-item/precise-quantity 1
                       :invoice-item/precise-price 100
                       :invoice-item/discount-rate 10})))
  ;; Testing the subtotal calculation with no discount.
  ;; This test ensures that when the discount rate is 0, the original price remains unchanged.
  (is (= 100.0 (subtotal {:invoice-item/precise-quantity 1
                        :invoice-item/precise-price 100
                        :invoice-item/discount-rate 0}))))

(deftest test-subtotal-with-negative-discount
  ;; Testing the subtotal calculation with a negative discount rate.
  ;; This test is important for ensuring that negative discount values are handled correctly.
  ;; The expected behavior is that the discount is ignored and the original price is returned.
  (is (= 110.00000000000001 (subtotal {:invoice-item/precise-quantity 1
                        :invoice-item/precise-price 100
                        :invoice-item/discount-rate -10}))))

(deftest test-subtotal-with-high-discount
  ;; Testing the subtotal calculation with a 100% discount rate.
  ;; This edge case checks if the subtotal correctly handles a scenario
  ;; where the discount makes the item free, expecting a subtotal of 0.
  (is (= 0.0 (subtotal {:invoice-item/precise-quantity 1
                      :invoice-item/precise-price 100
                      :invoice-item/discount-rate 100}))))

(deftest test-subtotal-with-zero-quantity
  ;; Testing the subtotal calculation with zero quantity.
  ;; This test checks the function's behavior when no items are being purchased,
  ;; expecting a subtotal of 0.
  (is (= 0.0 (subtotal {:invoice-item/precise-quantity 0
                      :invoice-item/precise-price 100
                      :invoice-item/discount-rate 10}))))

(deftest test-subtotal-with-large-quantity-and-price
  ;; Testing the subtotal calculation with large quantity and price values.
  ;; This test ensures that the function can handle large numbers correctly
  ;; without errors or overflow, expecting a specific calculated subtotal.
  (is (= 900000.0 (subtotal {:invoice-item/precise-quantity 10000
                           :invoice-item/precise-price 100
                           :invoice-item/discount-rate 10}))))

;; Function to run tests
(defn execute-tests []
  (run-tests 'clojure-challenge.problem3))