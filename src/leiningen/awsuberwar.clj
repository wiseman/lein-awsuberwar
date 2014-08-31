(ns leiningen.awsuberwar
  (:require [leiningen.compile :as compile]
            [leiningen.core.classpath :as classpath]
            [leiningen.core.project :as project]
            [leiningen.ring.uberwar :as uberwar]
            [leiningen.ring.util :as util]
            [leiningen.ring.war :as war]
            [robert.hooke]))


(defn skip-file? [original_func project war-path file]
  (and (not (re-find #".ebextensions.*" war-path))
       (original_func project war-path file)))


(def hooked (atom 0))


(defn awsuberwar
  "Creates a valid Amazon web services WAR that
   is deployable to servlet containers."
  ([project]
     (awsuberwar project (uberwar/default-uberwar-name project)))
  ([project war-name]
     (when (= 0 @hooked)
       (do
         (robert.hooke/add-hook #'war/skip-file? #'skip-file?)
         (swap! hooked inc)))
     (util/ensure-handler-set! project)
     (let [project (-> project
                       (project/merge-profiles [:awsuberwar])
                       uberwar/unmerge-profiles
                       war/add-servlet-dep)
           result  (compile/compile project)]
       (when-not (and (number? result) (pos? result))
         (let [war-path (war/war-file-path project war-name)]
           (war/compile-servlet project)
           (if (war/has-listener? project)
             (war/compile-listener project))
           (uberwar/write-uberwar project war-path)
           war-path)))))
