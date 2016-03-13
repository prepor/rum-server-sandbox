(ns exchange.ui
  (:require [rum.core :as rum]))

(rum/defc main
  [name]
  [:span (str "Hello, " name)])

(rum/defc layout
  []
  [:html
   [:head]
   [:body
    [:div#main (main "Andrew")]
    [:script {:src "/static/js/ui.js" :type "text/javascript"}]
    [:script {:type "text/javascript"}
     "exchange.ui.render_client()"]]])

#?(:clj
   (defn render-server
     []
     (rum/render-html (layout))))

#?(:cljs
   (defn ^:export render-client
     []
     (enable-console-print!)
     (rum/mount (main "Petr") (js/document.getElementById "main"))))

