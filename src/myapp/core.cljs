(ns myapp.core
  (:require [reagent.core :as r]
            [semantic-ui-react :refer (Button Image Container Menu MenuItem Transition)]
            ))

(def anim-duration 300)

(def showing (r/atom false))

(defn fade-comp [in]
  [:> Transition {:visible in
                  :animation "slide up" :duration "500"
                     }
   [:div "I am toggled via a "
    [:code "Transition"]
    [:span " from "]
    [:a {:href "https://react.semantic-ui.com"}
     "Semantic UI React"]]])

(defn root []
  [:div
   [:> Menu
    [:> Container {}
     [:> MenuItem {:as "a" :header true}
      [:> Image {:size "mini" :src "https://react.semantic-ui.com/logo.png"
                 :style {:margin-right "1.5em"}}]
      "Project Name"
      ]
     [:> MenuItem {:as "a"}
      "Home"]]]
   [:h1 "An experiment with shadow-cljs"]
   [:div "Click on the button below to: "]
   [:> Button {:on-click (fn []
                           (reset! showing (not @showing)))}
    (if @showing "Hide" "Show")]
   [fade-comp @showing]
   [:ul
    [:li "some"]
    [:li "more"]
    [:li "content"]]])

(defn mount-root []
  (r/render [root]
            (.getElementById js/document "app")))

(defn init []
  (mount-root))

