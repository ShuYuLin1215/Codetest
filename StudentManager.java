package com.lovo.manager;
import java.util.Scanner;


public class StudentManager {

    public static void main(String[] args) {
        String[] user = new String[10];
        int[] password = new int[10];
        while (true) {
            // 菜單
            System.out.println("A 注冊");
            System.out.println("B 登錄");
            System.out.println("C 退出");

            System.out.println("請選擇菜單：");
            Scanner scan = new Scanner(System.in);
            String operator = scan.nextLine();
            operator = operator.toUpperCase();// 大小寫互轉
            // "SFCDS" 轉換為一個一個的'S','F','C','D','S'
            char[] chr = operator.toCharArray();// 把字符串（String）轉化為char數組

            switch (chr[0]) {
            case 'A':
                register(user, password);
                break;
            case 'B':
                login(user, password);
                break;
            case 'C':
                System.out.println("退出系統！");
                System.exit(-1);
                break;
            default:
                System.out.println("操作錯誤,請從新輸入！");
                break;
            }
        }
    }

    /**
     * 登錄
     */
    public static void login(String[] user, int[] password) {

        System.out.println("輸入用戶名：");
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();

        System.out.println("輸入密碼：");
        int pwd = input.nextInt();

        int index = -1;
        for (int i = 0; i < user.length; i++) {
            if (userName.equals(user[i]) && pwd == password[i]) {// 如果用戶名與密碼匹配
                System.out.println("登錄成功!");
                studentMenu(userName);
                index = i;
                break;
            }
        }
        if (index == -1) {// 如果沒有找到下標，則登錄失敗
            System.out.println("登錄失敗！");
            return;
        }
    }

    /**
     * 注冊
     */
    public static void register(String[] user, int[] password) {

        System.out.println("請輸入用戶名");
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();

        System.out.println("請輸入密碼");
        int pwd = scan.nextInt();
        // 字符串中默認的數據是null,循環檢查,一旦遇到null，
        // 就輸入用戶名和密碼，把值賦值進去。
        for (int i = 0; i < user.length; i++) {
            if (user[i] == null) {
                user[i] = userName;
                password[i] = pwd;
                break;
            }
        }
    }

    /**
     * 學生菜單
     */
    public static void studentMenu(String user) {
        // 學生姓名與分數
        String[] studentName = new String[2];
        int[] score = new int[2];
        boolean flag = false;
        while (true) {

            System.out.println("***歡迎您" + user + "***");

            System.out.println("A 新增學生成績");
            System.out.println("B 修改學生成績");
            System.out.println("C 刪除學生成績");
            System.out.println("D 查詢學生成績");
            System.out.println("E 返回上級菜單");

            System.out.println("請選擇菜單：");
            Scanner input = new Scanner(System.in);
            String operator = input.nextLine();

            operator = operator.toUpperCase();
            char op = operator.toCharArray()[0];

            switch (op) {
            case 'A':
                addInfo(studentName, score);
                break;
            case 'B':
                updateInfo(studentName, score);
                break;
            case 'C':
                deleteInfo(studentName, score);
                break;
            case 'D':
                queryInfo(studentName, score);
                break;
            case 'E':
                flag = true;
                break;// 退出這個switch，如果在while中不多增加一個break，則會繼續循環不會返回上一級菜單
            default:
                System.out.println("操作錯誤,請從新輸入！");
                break;
            }
            if (flag) {
                break;// 退出這個while，就返回到了登陸菜單
            }
        }
    }

    /**
     * 新增學生信息
     * 
     * @param studentName
     * @param score
     */
    public static void addInfo(String[] studentName, int[] score) {

        for (int i = 0; i < studentName.length; i++) {
            System.out.println("請輸入學生姓名:");
            Scanner scan = new Scanner(System.in);
            String stName = scan.nextLine();
            studentName[i] = stName;

            System.out.println("請輸入學生成績:");
            int scr = scan.nextInt();

            score[i] = scr;
        }
    }

    /**
     * 修改學生姓名
     */
    public static void updateInfo(String[] studentName, int[] score) {
        System.out.println("請輸入學生姓名:");
        Scanner scan = new Scanner(System.in);
        String stName = scan.nextLine();
        // 通過名字修改分數
        int index = -1;
        for (int i = 0; i < score.length; i++) {// 通過遍歷，輸入的數與數組中的數據元素比較
            if (stName.equals(studentName[i])) {// 如果找到這個學生姓名，就記錄下標
                index = i;
            }
        }
        // 輸入一個分數
        System.out.println("請輸入學生成績:");
        int scr = scan.nextInt();

        score[index] = scr;// 把輸入的成績賦值給，index記錄找到的這個 下標
    }

    /**
     * 刪除員工數據
     */
    public static void deleteInfo(String[] studentName, int[] score) {
        // 刪除人名、刪除分數
        System.out.println("請輸入學生姓名:");
        Scanner scan = new Scanner(System.in);
        String stName = scan.nextLine();
        boolean flag = false;
        for (int i = 0; i < studentName.length; i++) {

            if (studentName.length - 1 == i) { // 當前下標是最后一個的話，就退出循環
                studentName[i] = null;
                score[i] = 0;
                break;
            }
            if (stName.equals(studentName[i]) || flag) { // 如果發現這個名字，就用當前數組元素的下一個元素，向前移動替換當前這個元素
                flag = true;
                studentName[i] = studentName[i + 1];
                score[i] = score[i + 1];
            }
        }
        for (int i = 0; i < studentName.length; i++) {
            System.out.println("學生姓名=" + studentName[i] + ",成績=" + score[i]);
        }
    }

    /**
     * 查詢學生信息
     */
    public static void queryInfo(String[] studentName, int[] score) {
        boolean flag = false;
        while (true) {
            
            System.out.println("A 查詢單個學生信息");
            System.out.println("B 查詢所有學生信息");
            System.out.println("C 返回上級菜單");

            System.out.println("請選擇菜單：");
            Scanner scan = new Scanner(System.in);
            String operator = scan.nextLine();
            operator = operator.toUpperCase();// 大小寫互轉

            char chr = operator.toCharArray()[0];
            switch (chr) {
            case 'A':
                querySinglStudentInfo(studentName, score);
                break;
            case 'B':
                queryAllStudentInfo(studentName, score);
                break;
            case 'C':
                flag = true;
                break;
            default:
                System.out.println("操作錯誤,請從新輸入！");
                break;
            }
            if(flag) {
                break;
            }
        }

    }

    /**
     * 查詢單個學生信息
     */
    public static void querySinglStudentInfo(String[] studentName, int[] score) {
        System.out.println("請輸入學生姓名:");
        Scanner scan = new Scanner(System.in);
        String stName = scan.nextLine();

        for (int i = 0; i < studentName.length; i++) {
            if (stName.equals(studentName[i])) {
                System.out.println("學生：" + studentName[i] + ",成績：" + score[i]);
                break;
            }
        }
    }

    /**
     * 查詢所有學生信息
     */
    public static void queryAllStudentInfo(String[] studentName, int[] score) {
        for (int i = 0; i < studentName.length; i++) {
            System.out.println("學生：" + studentName[i] + ",成績：" + score[i]);
        }
    }
}