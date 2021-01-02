package com.lovo.manager;
import java.util.Scanner;


public class StudentManager {

    public static void main(String[] args) {
        String[] user = new String[10];
        int[] password = new int[10];
        while (true) {
            // ���
            System.out.println("A �`�U");
            System.out.println("B �n��");
            System.out.println("C �h�X");

            System.out.println("�п�ܵ��G");
            Scanner scan = new Scanner(System.in);
            String operator = scan.nextLine();
            operator = operator.toUpperCase();// �j�p�g����
            // "SFCDS" �ഫ���@�Ӥ@�Ӫ�'S','F','C','D','S'
            char[] chr = operator.toCharArray();// ��r�Ŧ�]String�^��Ƭ�char�Ʋ�

            switch (chr[0]) {
            case 'A':
                register(user, password);
                break;
            case 'B':
                login(user, password);
                break;
            case 'C':
                System.out.println("�h�X�t�ΡI");
                System.exit(-1);
                break;
            default:
                System.out.println("�ާ@���~,�бq�s��J�I");
                break;
            }
        }
    }

    /**
     * �n��
     */
    public static void login(String[] user, int[] password) {

        System.out.println("��J�Τ�W�G");
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();

        System.out.println("��J�K�X�G");
        int pwd = input.nextInt();

        int index = -1;
        for (int i = 0; i < user.length; i++) {
            if (userName.equals(user[i]) && pwd == password[i]) {// �p�G�Τ�W�P�K�X�ǰt
                System.out.println("�n�����\!");
                studentMenu(userName);
                index = i;
                break;
            }
        }
        if (index == -1) {// �p�G�S�����U�СA�h�n������
            System.out.println("�n�����ѡI");
            return;
        }
    }

    /**
     * �`�U
     */
    public static void register(String[] user, int[] password) {

        System.out.println("�п�J�Τ�W");
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();

        System.out.println("�п�J�K�X");
        int pwd = scan.nextInt();
        // �r�Ŧꤤ�q�{���ƾڬOnull,�`���ˬd,�@���J��null�A
        // �N��J�Τ�W�M�K�X�A��Ƚ�ȶi�h�C
        for (int i = 0; i < user.length; i++) {
            if (user[i] == null) {
                user[i] = userName;
                password[i] = pwd;
                break;
            }
        }
    }

    /**
     * �ǥ͵��
     */
    public static void studentMenu(String user) {
        // �ǥͩm�W�P����
        String[] studentName = new String[2];
        int[] score = new int[2];
        boolean flag = false;
        while (true) {

            System.out.println("***�w��z" + user + "***");

            System.out.println("A �s�W�ǥͦ��Z");
            System.out.println("B �ק�ǥͦ��Z");
            System.out.println("C �R���ǥͦ��Z");
            System.out.println("D �d�߾ǥͦ��Z");
            System.out.println("E ��^�W�ŵ��");

            System.out.println("�п�ܵ��G");
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
                break;// �h�X�o��switch�A�p�G�bwhile�����h�W�[�@��break�A�h�|�~��`�����|��^�W�@�ŵ��
            default:
                System.out.println("�ާ@���~,�бq�s��J�I");
                break;
            }
            if (flag) {
                break;// �h�X�o��while�A�N��^��F�n�����
            }
        }
    }

    /**
     * �s�W�ǥͫH��
     * 
     * @param studentName
     * @param score
     */
    public static void addInfo(String[] studentName, int[] score) {

        for (int i = 0; i < studentName.length; i++) {
            System.out.println("�п�J�ǥͩm�W:");
            Scanner scan = new Scanner(System.in);
            String stName = scan.nextLine();
            studentName[i] = stName;

            System.out.println("�п�J�ǥͦ��Z:");
            int scr = scan.nextInt();

            score[i] = scr;
        }
    }

    /**
     * �ק�ǥͩm�W
     */
    public static void updateInfo(String[] studentName, int[] score) {
        System.out.println("�п�J�ǥͩm�W:");
        Scanner scan = new Scanner(System.in);
        String stName = scan.nextLine();
        // �q�L�W�r�ק����
        int index = -1;
        for (int i = 0; i < score.length; i++) {// �q�L�M���A��J���ƻP�Ʋդ����ƾڤ������
            if (stName.equals(studentName[i])) {// �p�G���o�Ӿǥͩm�W�A�N�O���U��
                index = i;
            }
        }
        // ��J�@�Ӥ���
        System.out.println("�п�J�ǥͦ��Z:");
        int scr = scan.nextInt();

        score[index] = scr;// ���J�����Z��ȵ��Aindex�O����쪺�o�� �U��
    }

    /**
     * �R�����u�ƾ�
     */
    public static void deleteInfo(String[] studentName, int[] score) {
        // �R���H�W�B�R������
        System.out.println("�п�J�ǥͩm�W:");
        Scanner scan = new Scanner(System.in);
        String stName = scan.nextLine();
        boolean flag = false;
        for (int i = 0; i < studentName.length; i++) {

            if (studentName.length - 1 == i) { // ��e�U�ЬO�̦Z�@�Ӫ��ܡA�N�h�X�`��
                studentName[i] = null;
                score[i] = 0;
                break;
            }
            if (stName.equals(studentName[i]) || flag) { // �p�G�o�{�o�ӦW�r�A�N�η�e�Ʋդ������U�@�Ӥ����A�V�e���ʴ�����e�o�Ӥ���
                flag = true;
                studentName[i] = studentName[i + 1];
                score[i] = score[i + 1];
            }
        }
        for (int i = 0; i < studentName.length; i++) {
            System.out.println("�ǥͩm�W=" + studentName[i] + ",���Z=" + score[i]);
        }
    }

    /**
     * �d�߾ǥͫH��
     */
    public static void queryInfo(String[] studentName, int[] score) {
        boolean flag = false;
        while (true) {
            
            System.out.println("A �d�߳�ӾǥͫH��");
            System.out.println("B �d�ߩҦ��ǥͫH��");
            System.out.println("C ��^�W�ŵ��");

            System.out.println("�п�ܵ��G");
            Scanner scan = new Scanner(System.in);
            String operator = scan.nextLine();
            operator = operator.toUpperCase();// �j�p�g����

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
                System.out.println("�ާ@���~,�бq�s��J�I");
                break;
            }
            if(flag) {
                break;
            }
        }

    }

    /**
     * �d�߳�ӾǥͫH��
     */
    public static void querySinglStudentInfo(String[] studentName, int[] score) {
        System.out.println("�п�J�ǥͩm�W:");
        Scanner scan = new Scanner(System.in);
        String stName = scan.nextLine();

        for (int i = 0; i < studentName.length; i++) {
            if (stName.equals(studentName[i])) {
                System.out.println("�ǥ͡G" + studentName[i] + ",���Z�G" + score[i]);
                break;
            }
        }
    }

    /**
     * �d�ߩҦ��ǥͫH��
     */
    public static void queryAllStudentInfo(String[] studentName, int[] score) {
        for (int i = 0; i < studentName.length; i++) {
            System.out.println("�ǥ͡G" + studentName[i] + ",���Z�G" + score[i]);
        }
    }
}