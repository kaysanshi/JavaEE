package com.leo.course.scheduling.spring_boot_scheduling;
import java.util.Arrays;

/**
* @Author Qfeng
* @Date 2019-03-19 10:14:02
*/
public class Test {
	    private static int[][] jlarr = new int[5][6];//表示计科有5个班级6门课//数值表示每门课的每周上课次数
	    private static int[] jcarr = new int[5];//表示计科班级人数
	    private static int jlnum = 0;
	    private static int i = 0,j = 0;

	    private static int[][] klarr = new int[4][7];//表示会计有4个班级7门课//数值表示每门课的每周上课次数
	    private static int[] kcarr = new int[4];//表示会计班级人数
	    private static int klnum = 0;
	    private static int x = 0, y = 0;

	    private static int[][][] map = new int[5][4][10];// 周 节 教室 一周5天上课 一天4节课 共有10个教室
	    private static int[] roomnum = new int[10];//每间教室的容量
	    //1计科 班级 课
	    //2会计


	    private static void initData() {
			//初始化教室容纳量
	        roomnum[0] = 60;
	        roomnum[1] = 50;
	        roomnum[2] = 30;
	        roomnum[3] = 50;
	        roomnum[4] = 70;


	        roomnum[5] = 80;
	        roomnum[6] = 90;
	        roomnum[7] = 160;
	        roomnum[8] = 120;
	        roomnum[9] = 60;



	        for (int i = 0; i < 5; i++) {
	            Arrays.fill(jlarr[i], 2);
	            jlarr[i][1]++;
	            jlarr[i][3]++;
	            jlarr[i][5]++;
//	            System.out.print(Arrays.toString(jlarr[i]));
	        }
			//计科每个班级的人数
	        jcarr[0] = 20;
	        jcarr[1] = 40;
	        jcarr[2] = 30;
	        jcarr[3] = 35;
	        jcarr[4] = 42;

//	        System.out.println();

	        for (int i = 0; i < 4; i++) {
	            Arrays.fill(klarr[i], 2);
	            klarr[i][1] += 1;
	            klarr[i][3] += 2;
	            klarr[i][5] += 1;
//	            System.out.print(Arrays.toString(klarr[i]));
	        }
//	        System.out.println();
			//会计人数
	        kcarr[0] = 20;
	        kcarr[1] = 40;
	        kcarr[2] = 30;
	        kcarr[3] = 35;

//	        Arrays.fill();
	        for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 4; j++) {
	                Arrays.fill(map[i][j], -1);//-1表示没课
	            }
	        }
//	        for (int i = 0; i < 5; i++) {
//	            for (int j = 0; j < 4; j++) {
//	                System.out.print(Arrays.toString(map[i][j]));
//	            }
//	            System.out.println();
//	        }
	    }
		///判断是否是最后一个班级
	    private static boolean checkj() {
	        if (i == jlarr.length) {
	            return true;
	        } else {
	            return false;
	        }
	    }
		//判断是否是最后一个课程
	    private static boolean checkk() {
	        if (x == klarr.length) {
	            return true;
	        } else {
	            return false;
	        }
	    }
		//判断班级和课程是否排完
	    private static boolean checkOver() {
	        if (checkj() && checkk()) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    private static void search() {
	        if (checkOver())
	            return;
	        else {
	            //进行排课
				
	            for (int k = 0; k < map.length; k++) {
	                for (int l = 0; l < map[k].length; l++) {
	                    for (int m = 0; m < map[k][l].length; m++) {
	                        if (map[k][l][m] == -1) {//表示教室还没有使用
	                            //安排课程
	                            if (checkj()) {
	                                if (checkk()) {
	                                    return;
	                                } else {//安排会计课程
	                                    int val = 200 + x * 10 + y;
	                                    boolean flag = false;
	                                    for (int n = 0; n < m; n++) {
	                                        if (map[k][l][n] / 10 == val / 10) {
	                                            flag = true;
	                                            break;
	                                        }
	                                    }
	                                    if (flag)
	                                        continue;
	                                    if (roomnum[m] >= kcarr[x]) {//这个班可以容纳
	                                        klarr[x][y]--;
	                                    }
	                                    map[k][l][m] = val;
	                                    if (klarr[x][y] == 0) {//课上完了
	                                        y++;
	                                        if (y == klarr[0].length) {//这个班的所有课上完了
	                                            x++; y = 0;
	                                        }
	                                    }
	                                }
	                            } else { //安排计科课程
	                                int val = 100 + i * 10 + j;
	                                boolean flag = false;
	                                for (int n = 0; n < m; n++) {
	                                    if (map[k][l][n] / 10== val / 10) {
	                                        flag = true;
	                                        break;
	                                    }
	                                }
	                                if (flag)
	                                    continue;
	                                if (roomnum[m] >= jcarr[i]) {//这个班可以容纳
	                                    jlarr[i][j]--;
	                                }
	                                map[k][l][m] = val;
	                                if (jlarr[i][j] == 0) {//课上完了
	                                    j++;
	                                    if (j == jlarr[0].length) {//这个班的所有课上完了
	                                        i++; j = 0;
	                                    }
	                                }
	                            }
	                            search();
	                        }
	                    }
	                }
	            }
	        }
	    }

	    public static void main(String[] args) {
	        initData();

	        System.out.println("计科人数" + Arrays.toString(jcarr));
	        System.out.println("会计人数" + Arrays.toString(kcarr));

	        System.out.println("开始排课。。。");
	        search();
	        System.out.println("排课结束。。。");
	        for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 4; j++) {
	                System.out.print("周" + (i + 1) + "课" + (j + 1) + ":" + Arrays.toString(map[i][j]));
	            }
	            System.out.println();
	        }
	    }
}
