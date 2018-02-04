(ns myapp.core
  (:require [reagent.core :as r]))

(defn root []
  [:div
   [:h1 "Hello there :)"]])

(defn mount-root []
  (js/console.log "Mounting from mount-root")
  (r/render [root]
            (.getElementById js/document "app")))

(defn init []
  (js/console.log "Inited from myapp.core/init")
  (mount-root))

