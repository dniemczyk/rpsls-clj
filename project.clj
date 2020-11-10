(defproject rpsls-clj "0.1.0-SNAPSHOT"
  :description "A implementation of the quite famous
                rock-paper-scissors-lizzard-spock game"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :main ^:skip-aot rpsls-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[midje "1.9.9"]]
                   :plugins [[lein-midje "3.2.2"]]}})
