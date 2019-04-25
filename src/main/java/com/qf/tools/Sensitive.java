package com.qf.tools;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

/**
 * 敏感词过滤
 * 1.读取敏感词库
 * 2.初始化敏感词库，构建dfa算法模型
 * Created by ASUS on 2018/5/24
 *
 * @Authod Grey Wolf
 */

@Component
public class Sensitive {
    /**
     * 获取内容的敏感词
     * @param txt
     * @return
     */
    public Set<String> getSensitivateWord(String txt){
        Set<String>set=new HashSet<String>();
        int i;
        for (i=0;i<txt.length();i++){
            //判断是否包含敏感字符,返回敏感个数
            int length= 0;
            try {
                length = checkSensitiveWord(txt,i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(length>0){
                set.add(txt.substring(i,i+length));
                //因为for会自增
                i=i+length-1;
            }
        }
        return set;
    }

    /**
     * 使用自定义字符屏蔽内容敏感词
     * @param txt
     * @param replaceChar
     * @return
     */
    public String replaceSensitiveWord(String txt,String replaceChar){
        String resultTxt=txt;
        //获取内容中所有的敏感词
        Set<String>set=getSensitivateWord(txt);
//        System.out.println("获取所有敏感词：");
//        sysSet(set);
        Iterator<String> iterator=set.iterator();
        String word=null;
        String replaceTxt=null;
        while (iterator.hasNext()){
            word=iterator.next();
            //获取要替换的字符串
            replaceTxt=getReplaceTxt(replaceChar,word.length());
            resultTxt=resultTxt.replaceAll(word,replaceTxt);
        }
        return resultTxt;
    }

    /**
     * 读入本地敏感字典至Set表
     * @return
     */
    private Set<String> readSensitivateWord() throws Exception {
        Set<String>set = null;
        String url = System.getProperty("evan.webapp");
        url=url+"SensitiveWord.txt";
        File file=new File(url);

        InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream(file),"utf-8");
        if(file.exists()&&file.isFile()){
            // 设定表容量提高存入速度
            set=new HashSet<String>((int)(file.length()/0.75f+1.0f));
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String word=null;
            // 敏感词汇以行为单位载入
            while ((word=bufferedReader.readLine())!=null){
                set.add(word);
            }
        }else {
            throw new Exception("敏感词库文件不存在");
        }
        inputStreamReader.close();
        return set;
    }

    /**
     * 返回敏感词库列表模型
     * @param set
     * @return
     */
    private HashMap initSensitivateWord(Set<String>set){
        HashMap map=new HashMap(set.size());
        String key=null;
        Map nowMap=null;
        HashMap<String,Boolean> newMap=null;
        // 迭代敏感词库
        Iterator<String> iterator=set.iterator();
        while (iterator.hasNext()){
            // 每次迭代新词前把nowMap更新到总表
            nowMap=map;
            key=iterator.next();
            // 遍历单个词汇
            for (int i=0; i<key.length(); i++){
                // 每个字符都是一个map表，后一个字符是前一个字符map表的子集
                char keyChar = key.charAt(i);
                Object wordMap=nowMap.get(keyChar);
                // 存在，把nowMap指向该分支
                if(wordMap!=null){
                    nowMap= (Map) wordMap;
                }
                // 不存在，构建新分支
                else {
                    newMap=new HashMap<String,Boolean>();
                    newMap.put("isEnd",false);
                    nowMap.put(keyChar,newMap);
                    // 把 nowMap 指向到这个新创建的分支，以便下一次遍历继续追加字符
                    nowMap=newMap;
                }
                // 对当前词汇最后一个字符标记isEnd
                if (i==key.length()-1){
                    nowMap.put("isEnd",true);
                }
            }
        }
        return map;
    }

    /**
     * 检查文字中是否包含敏感字符
     * @param txt
     * @param begin
     * @return 如果存在，则返回敏感词字符的长度，不存在返回0
     */
    private int checkSensitiveWord(String txt, int begin) throws Exception {
        // 敏感词结束标识符
        boolean flag = false;
        // 匹配长度
        int matchFlag=0;
        char word=0;
        Map nowMap=initSensitivateWord(readSensitivateWord());
        int i;
        for (i=begin;i<txt.length();i++){
            word=txt.charAt(i);
            // 单字符查找是否有匹配
            nowMap=(Map)nowMap.get(word);
            if(nowMap!=null){
                // 单字匹配继续穷举
                matchFlag++;
                flag = (Boolean)nowMap.get("isEnd");
            }else{
                // 不存在，跳出
                break;
            }
        }
        // 匹配长度不足2个或者没有完整匹配单位敏感词
        if (matchFlag < 2|| !flag) {
            // 匹配标志归零
            matchFlag=0;
        }
        return matchFlag;
    }

    /**
     * 返回要替换敏感字符串
     * @param replaceChar
     * @param length
     * @return
     */
    private String getReplaceTxt(String replaceChar, int length) {
        int i;
        String word=replaceChar;
        for (i=1;i<length;i++){
            word+=replaceChar;
        }
        return word;
    }

//    /**
//     * 遍历Set表内容到控制台
//     * @param set
//     */
//    public void sysSet(Set<String> set){
//        for (String word:set){
//            System.out.println("word:"+word);
//        }
//    }
//
//    /**
//     * 遍历Map表内容到控制台
//     * @param map
//     */
//    private void sysMap(HashMap map){
//        Iterator entries = map.entrySet().iterator();
//
//        while (entries.hasNext()) {
//
//            Map.Entry entry = (Map.Entry) entries.next();
//
//            Object key = entry.getKey();
//
//            Object value = entry.getValue();
//
//            System.out.println("Key = " + key + ", Value = " + value);
//
//        }
//    }
}
