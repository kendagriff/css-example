(ns css-example.core
  (:require [quiescent :as q :include-macros true]
            [quiescent.dom :as dom]))

(enable-console-print!)

(declare app-state)
(declare render)

(def css-transition-group
  (-> js/React
      (aget "addons")
      (aget "CSSTransitionGroup")))

(q/defcomponent Frame2 []
  (dom/div nil "Goodbye, world!"))

(defn say-goodbye! []
  (reset! app-state {:frame Frame2})
  (render))

(q/defcomponent Frame1 []
  (dom/div
    nil
    (dom/div nil "Hello, world!")
    (dom/button
      {:onClick say-goodbye!}
      "Continue")))

(def app-state (atom {:frame Frame1}))

(q/defcomponent App [state]
  (css-transition-group
    #js {:transitionName "example"}
    ((:frame state)))) ;; Call function defined by :frame

(defn render []
  (q/render
    (App @app-state)
    (.getElementById js/document "app")))

(render)
