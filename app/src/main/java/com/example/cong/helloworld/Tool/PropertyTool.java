package com.example.cong.helloworld.Tool;

import android.content.Context;
import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by cong on 2017-06-01.
 * 属性的存取
 */

public class PropertyTool {

    /**
     * 使用属性文件保存用户的信息
     *
     * @param context 上下文
     * @param key 属性名
     * @param value  属性值
     * @return
     */
    public static void saveInfo(Context context, String key,String value) {
        try {
            // 使用Android上下问获取当前项目的路径
            File file = new File(context.getFilesDir(), "info.properties");
            // 创建输出流对象
            FileOutputStream fos = new FileOutputStream(file,true);
            // 创建属性文件对象
            Properties pro = new Properties();
            // 设置用户名或密码
            pro.setProperty(key, value);

            // 保存文件
            pro.store(fos, "info.properties");

            // 关闭输出流对象
            fos.close();

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }



    public static void saveInfos(Context context,String[] keys,String[] values){
        try {
            // 使用Android上下问获取当前项目的路径
            File file = new File(context.getFilesDir(), "info.properties");
            // 创建输出流对象
            FileOutputStream fos = new FileOutputStream(file,true);
            // 创建属性文件对象
            Properties pro = new Properties();
            //
            for(int i=0;i<keys.length;i++){

                if(values[i]==null)
                    values[i]="";
                pro.setProperty(keys[i], values[i]);
            }


            // 保存文件
            pro.store(fos, "info.properties");

            // 关闭输出流对象
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getInfo(Context context, String key){
        // 获取属性文件对象
        Properties pro=getProObject(context);

        if (null != pro) {
            return pro.getProperty(key);
        }else{
            return "";
        }
    }


    /**
     * 返回属性文件对象
     *
     * @param context 上下文
     * @return
     */
    public static Properties getProObject(Context context) {
        try {
            // 创建File对象
            File file = new File(context.getFilesDir(), "info.properties");
            // 创建FileIutputStream 对象
            FileInputStream fis = new FileInputStream(file);
            // 创建属性对象
            Properties pro = new Properties();
            // 加载文件
            pro.load(fis);
            // 关闭输入流对象
            fis.close();
            return pro;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void clear(Context context){
        try {
            // 使用Android上下问获取当前项目的路径
            File file = new File(context.getFilesDir(), "info.properties");
            // 创建输出流对象
            FileOutputStream fos = new FileOutputStream(file,false);
            // 创建属性文件对象
            Properties pro = new Properties();

            // 保存文件
            pro.store(fos, "info.properties");

            // 关闭输出流对象
            fos.close();

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }




}
