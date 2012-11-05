package main;

/**
 * ゲーム内における4つの方向を表します。
 */
public enum Direction4 {
        /**
         * 右方向
         */
        RIGHT(0, 1),
        /**
         * 上方向
         */
        UP(-1, 0),
        /**
         * 左方向
         */
        LEFT(0, -1),
        /**
         * 下方向
         */
        DOWN(1, 0),
        /**
         * 動かない
         */
        STOP(0, 0), ;


        /**
         * 方向を示すX座標
         */
        public final int dx;
        /**
         * 方向を示すY座標
         */
        public final int dy;

        private Direction4(int x, int y) {
                this.dx = x;
                this.dy = y;
        }

        /**
         * このDirectionが示す(x, y)座標におけるPoint表現を返します。
         *
         * @return このDirectionが示す(x, y)座標におけるPoint表現
         */
        public Point2 toPoint() {
                return new Point2(dx, dy);
        }

        /**
         * この方向とは逆の方向を取得します．
         *
         * @return 逆の方向
         */
        public Direction4 getOpposite() {
                switch (this) {
                case DOWN:
                        return Direction4.UP;
                case LEFT:
                        return Direction4.RIGHT;
                case RIGHT:
                        return Direction4.LEFT;
                case UP:
                        return Direction4.DOWN;
                }
                return null;
        }
}