(defproject css-example "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2173"]
                 [quiescent "0.1.1"]]
  :plugins [[lein-cljsbuild "1.0.2"]]
  :source-paths ["src"]
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :profiles {:dev {:dependencies [[com.cemerick/piggieback "0.1.3"]]}}
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src"]
                        :compiler {:output-to "css_example.js"
                                   :output-dir "out"
                                   :optimizations :none
                                   :source-map true}}]})
