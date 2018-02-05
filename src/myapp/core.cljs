(ns myapp.core
  (:require [reagent.core :as r]
            ["semantic-ui-react" :refer (Button Image Container Menu MenuItem)]
            ))

(defn root []
  [:div
   [:> Menu {:fixed "top"}
    [:> Container {}
     [:> MenuItem {:as "a" :header true}
      [:> Image {:size "mini" :src "https://react.semantic-ui.com/logo.png"
                 :style {:margin-right "1.5em"}}]
      "Project Namespace"
      ]
     [:> MenuItem {:as "a"}
      "Home"
      ]
     ]]
   [:h1 "Hello there :)"]
   [:> Button {} "Click me"]
   ])

(defn mount-root []
  (js/console.log "Mounting from mount-root")
  (r/render [root]
            (.getElementById js/document "app")))

(defn init []
  (js/console.log "Inited from myapp.core/init")
  (mount-root))

