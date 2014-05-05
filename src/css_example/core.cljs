(ns css-example.core
  (:require [quiescent :as q :include-macros true]
            [quiescent.dom :as dom]))

(enable-console-print!)

(declare app-state)
(declare render)
(declare Frame1)
(declare Frame2)

(def css-transition-group
  (-> js/React
      (aget "addons")
      (aget "CSSTransitionGroup")))

(defn frame1 []
  (dom/div #js {:key "frame-1"} (Frame1)))

(defn frame2 []
  (dom/div #js {:key "frame-2"} (Frame2)))

(q/defcomponent Frame2 []
  (dom/div nil "Goodbye, world!"))

(defn say-goodbye! []
  (reset! app-state {:frame frame2})
  (render))

(q/defcomponent Frame1 []
  (dom/div
    nil
    (dom/div nil "Hello, world!")
    (dom/button
      {:onClick say-goodbye!}
      "Continue")))

(def app-state (atom {:frame frame1}))

(q/defcomponent App [state]
  (css-transition-group
    #js {:transitionName "example"}
    ((:frame state)))) ;; Call function defined by :frame

(defn render []
  (q/render
    (App @app-state)
    (.getElementById js/document "app")))

(render)
