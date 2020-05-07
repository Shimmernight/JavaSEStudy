package houseWork.处理游戏异常;

import java.io.*;

public class Gobang {
    // 定义棋盘的大小
    private static int BOARD_SIZE = 15;
    // 定义一个二维数组来充当棋盘
    private String[][] board;

    public void initBoard() {
        // 初始化棋盘数组
        board = new String[BOARD_SIZE][BOARD_SIZE];
        // 把每个元素赋为"╋"，用于在控制台画出棋盘
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = "╋-";
            }
        }
    }

    // 在控制台输出棋盘的方法
    public void printBoard() {
        // 打印每个数组元素
        System.out.println(" 1 2 3 4 5 6 7 8 9 A B C D E F");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(Integer.toHexString(i + 1).toUpperCase());
            for (int j = 0; j < BOARD_SIZE; j++) {
                // 打印数组元素后不换行
                System.out.print(board[i][j]);
            }
            // 每打印完一行数组元素后输出一个换行符
            System.out.print("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        boolean b = false;
        Gobang gb = new Gobang();
        gb.initBoard();
        gb.printBoard();
        System.out.print("请白手输入坐标，应以x,y的格式：");
        // 这是用于获取键盘输入的方法
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = null;
        // br.readLine()：每当在键盘上输入一行内容按回车，用户刚输入的内容将被br读取到。
        while ((inputStr = br.readLine()) != null) {
            // 将用户输入的字符串以逗号（,）作为分隔符，分隔成2个字符串
            String[] posStrArr = inputStr.split(",");
            if (posStrArr.length > 2) {
                System.out.print("输入格式不正确，请重新输入：");
                continue;
            }
            int xPos;
            int yPos;
            try {
                // 将2个字符串转换成用户下棋的座标
                xPos = Integer.parseInt(posStrArr[0]);
                yPos = Integer.parseInt(posStrArr[1]);
            } catch (NumberFormatException e) {
                System.out.print("输入内容有误，请重新输入：");
                continue;
            }

            if ((xPos <= 0 | xPos > BOARD_SIZE) | (yPos <= 0 | yPos > BOARD_SIZE)) {
                System.out.print("输入的棋子坐标越界，请重新输入：");
                continue;
            }
            if (gb.board[yPos - 1][xPos - 1].compareToIgnoreCase("╋-") != 0) {
                System.out.print("该位置已有棋子，请重新输入：");
                continue;
            }
            System.out.println("x:" + xPos + " y:" + yPos);
            // 把对应的数组元素赋为"●"○。
            if (!b) {
                gb.board[yPos - 1][xPos - 1] = "○ ";
                b = true;
            } else {
                gb.board[yPos - 1][xPos - 1] = "● ";
                b = false;
            }
            gb.printBoard();
            if (!b)
                System.out.print("请白手输入坐标，应以x,y的格式：");
            else
                System.out.print("请黑手输入坐标，应以x,y的格式：");
        }
    }
}