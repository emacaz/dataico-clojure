# Engineering Challenge

## Overview

This engineering challenge consists of three problems that test your Clojure programming skills. You will need to complete the following tasks:

1. Create a GitHub/GitLab repository to showcase your challenge solutions.
2. Solve the three problems outlined below.
3. Provide explanations and code documentation as necessary.
4. Submit your challenge results by sharing the repository link.

## Getting Started

Follow these steps to set up your development environment and get started:

1. Install the Cursive Plugin for IntelliJ IDEA if you haven't already. Cursive is a popular Clojure development tool that provides essential features for Clojure projects. You can find installation instructions [here](https://cursive-ide.com/userguide/deps.html).

2. Clone or fork this repository to your local machine to access the challenge problems.

3. Use the provided Clojure project configuration (deps.edn) to ensure your project dependencies are correctly set up.

4. Enjoy working on the challenge and building your Clojure skills!


## Running the Solutions

You can easily run all solutions from main.clj. Here's how:

1. Open a terminal and navigate to the project's root directory.
2. Copy and paste or run the command: `clj -M -m main`.
3. This will execute the solutions for Problem 1, Problem 2, and Problem 3 in sequence, as set up in the `main.clj` file.

## Problems

### Problem 1: Thread-Last Operator `->>`

In this problem, you will work with an invoice defined in the `invoice.edn` file in the repository. Your task is to use the thread-last `->>` operator to find all invoice items that satisfy specific conditions. Write a function that takes an invoice as an argument and returns all items that meet the conditions described below.

#### Requirements

To load the invoice for testing, use the following code snippet:

```clojure
(def invoice (clojure.edn/read-string (slurp "resources/invoice.edn")))
Definitions
```
An invoice item is represented as a Clojure map with an :invoice-item/id field. Example:

```clojure
{:invoice-item/id     "ii2"  
  :invoice-item/sku "SKU 2"}
```

An invoice has two fields: `:invoice/id (its identifier)` and ```:invoice/items``` (a vector of invoice items).
Invoice Item Conditions
Your function should find items that satisfy the following conditions:

At least one item must have a `:tax/category` of `:iva` and a `:tax/rate` of `19`.
At least one item must have a `:retention/category` of `:ret_fuente` and a `:retention/rate` of `1`.
Every item must satisfy EXACTLY one of the above two conditions. This means that an item cannot have BOTH `:iva 19%` and retention `:ret_fuente 1%`.

Problem 2: Core Generating Functions
For this problem, you will work with an invoice defined in the `invoice.json` file in the repository. Your goal is to generate an invoice that passes the spec `::invoice` defined in `invoice_spec.clj`. Write a function that takes a JSON file name as an argument and returns a Clojure map. The map should represent an invoice constructed from the JSON file.

Use the following code snippet to check if the generated invoice passes the spec:

```clojure
(s/valid? ::invoice invoice)
```

Problem 3: Test-Driven Development
In this problem, you will test the subtotal function defined in `invoice-item.clj`. The function calculates the subtotal of an invoice item while taking a discount rate into account. Your task is to write at least five tests using Clojure's deftest to demonstrate the correctness of the subtotal function. Make sure to cover various edge cases in your tests.

Project Structure
Here's the directory structure of the challenge repository:

css
```
.
├── README.md
├── dataico.iml
├── deps.edn
├── resources
│   ├── invoice.edn
│   └── invoice.json
└── src
    ├── clojure_challenge
    │   ├── invoice_item.clj
    │   ├── invoice_spec.clj
    │   ├── problem1.clj
    │   ├── problem2.clj
    │   └── problem3.clj
    └── main.clj

```
You will find the problem descriptions, sample code, and data files in their respective locations within this structure.

Happy coding and good luck with the challenge!