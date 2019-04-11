package com.dh.mapperte.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ParameterUtils {
    // 计算总分
    public static double calculateSum(List<Double> scroceList){
        double sums = 0.0;
        for (int i = 0; i < scroceList.size(); i++) {
            sums += scroceList.get(i);
        }
        return sums;
    }
    // 计算最高分
    public static double calculateMax(List<Double> scroceList){
        double max = 0.0;
        for (int i = 0; i < scroceList.size(); i++) {
            if (max < scroceList.get(i)){
                max=scroceList.get(i);
            }
        }
        return max;
    }
    // 计算最低分
    public static double calculateMin(List<Double> scroceList){
        double min = 2000;
        for (int i = 0; i < scroceList.size(); i++) {
            if (min > scroceList.get(i)){
                min=scroceList.get(i);
            }
        }
        return min;
    }
    public static double calculateRange(List<Double> scroceList){
        return calculateMax(scroceList)-calculateMin(scroceList);
    }
    /**
     *
     * @param scroceList
     * @param score
     * @return 及格率
     */
    public static double calculatePassRate(List<Double> scroceList,double score){
        int count = 0;
        for (int i = 0; i < scroceList.size(); i++) {
            if (score > scroceList.get(i)){
                count++;
            }
        }
        return count*1.0/scroceList.size();
    }
    // 计算平均分
    public static double calculateAverage(List<Double> scroceList){
        return calculateSum(scroceList)*1.0/scroceList.size();
    }
    // 计算中位数
    public static double calculateMedian(List<Double> scroceList){
        Collections.sort(scroceList);
        int index = scroceList.size()/2;
        if (scroceList.size()%2 == 0){
            return (scroceList.get(index)+scroceList.get(index-1))/2.0;
        }
        return scroceList.get(index);
    }
    /**
     *
     * @param scroceList 分数集合
     * @param average 平均分
     * @return 计算标准差
     */
    public static double calculateStd(List<Double> scroceList,double average){
        double sum = 0;
        for (int i = 0; i < scroceList.size(); i++) {
            sum += (scroceList.get(i)-average)*(scroceList.get(i)-average);
        }
        return Math.sqrt(sum/scroceList.size());
    }

    /**
     *
     * @param scroce 学生分数
     * @param std 标注差
     * @param average 平均分
     * @return 标准分
     */
    public static double calculateStandardScore(double scroce,double std,double average){
        return (scroce-average)/std;
    }
    /**
     *
     * @param average 平均分
     * @param mark 满分值
     * @return 难度
     */
    public static double calculateDifficulty(double average,int mark){
        BigDecimal bg = new BigDecimal(1-average/(mark*1.0));
        return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     *
     * @param scroceList 分数集合
     * @param mark 满分
     * @return 区分度
     */
    public static double calculateDiscrimination(List<Double> scroceList,int mark){
        Collections.sort(scroceList, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1-o2>0?-1:1;
            }
        });
        double sum1 = 0.0;
        double sum2 = 0.0;
        int size = scroceList.size() / 4 == 0?1:scroceList.size() / 4;
        for (int i = 0; i < size; i++) {
            sum1 += scroceList.get(i);
        }
        for (int i = scroceList.size()*3/4; i < scroceList.size(); i++) {
            sum2 += scroceList.get(i);
        }
        BigDecimal bg = new BigDecimal((sum1/size-sum2/( scroceList.size()-scroceList.size()*3/4))/(mark*1.0));
        return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
