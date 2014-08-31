(defproject lein-awsuberwar "0.1.2"
  :description "Creates an uberwar that includes .ebextensions, if it exists."
  :url "https://github.com/wiseman/lein-awsuberwar"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :deploy-repositories {"releases" :clojars}
  :eval-in-leiningen true
  :plugins [[lein-ring "0.8.11"]]
  :dependencies [[lein-ring "0.8.11"]])
