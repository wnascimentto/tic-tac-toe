(ns tic-tac-toe.board-test
  (:require [tic-tac-toe.board :as board]
            [clojure.test :refer [is deftest testing]]))

(defn update-get
  [value position]
  (->> value
       (board/update-board board/board position)
      (#(get-in % position))))

(deftest board-update
  (testing "should update when the position fit in the board"
    (is (= :x (update-get :x [0 0])))
    (is (= :x (update-get :x [2 2]))))

  (testing "should return nil whe the position not fit in the board"
    (is (nil? (board/update-board board/board [0 3] :x)))
    (is (nil? (board/update-board board/board [-1 -1] :x)))))
