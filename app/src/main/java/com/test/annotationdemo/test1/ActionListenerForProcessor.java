package com.test.annotationdemo.test1;

import android.view.View;
import android.widget.Button;

import java.lang.reflect.Field;

public class ActionListenerForProcessor {

    public static void processAnnotations(Object obj) {
        try {
            //1、获取object对象的类
            Class cl = obj.getClass();
            //2、获取类中所有的成员变量元素
            for (Field f : cl.getDeclaredFields()) {
                //3、成员变量设置为自由访问
                f.setAccessible(true);
                //4、获取成员变量的注解
                ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
                //5、获取成员变量f的实例
                Object fObj = f.get(obj);
                if (a != null && fObj != null && fObj instanceof Button) {
                    //6、获取 a 注解里的listener 元数据（它是一个监听器类）
                    Class<? extends View.OnClickListener> listenerClass = a.listener();
                    //7、使用反射来创建listerner类的对象
                    ClickProcess listener = (ClickProcess) listenerClass.newInstance();
                    //8、给实例增加点击事件
                    Button button = (Button) fObj;
                    button.setOnClickListener(listener);
                }
            }
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
