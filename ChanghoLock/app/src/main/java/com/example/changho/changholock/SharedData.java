package com.example.changho.changholock;

import java.util.ArrayList;

/**
 * Created by Changho on 2016-09-19.
 */

/**
 * 모든 클래스가 참조하는 타겟리스트 목록
 */
public class SharedData {
     static ArrayList<String> targetedList = new ArrayList<>();
     static String currentActivity;
     static ArrayList<String> installedApps = new ArrayList<>();
}
