(defproject flock-shaman "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/core.async "0.2.374"]

                 [ua.modnakasta/rum "0.6.0-10"]
                 [cljsjs/react-dom-server "0.14.3-0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [io.pedestal/pedestal.jetty "0.4.1"]
                 [io.pedestal/pedestal.service "0.4.1"]
                 [ch.qos.logback/logback-classic "1.1.2" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.7"]
                 [org.slf4j/jcl-over-slf4j "1.7.7"]
                 [org.slf4j/log4j-over-slf4j "1.7.7"]
                 [figwheel "0.5.0-6"]]
  :plugins [[lein-figwheel "0.5.0-6"]]
  :cljsbuild {:builds [{:id "main"
                        :source-paths ["src/"]
                        :figwheel true
                        :compiler {:main "exchange.ui"
                                   :asset-path "/static/js/out"
                                   :output-to "resources/public/static/js/ui.js"
                                   :output-dir "resources/public/static/js/out" } } ]
              })
