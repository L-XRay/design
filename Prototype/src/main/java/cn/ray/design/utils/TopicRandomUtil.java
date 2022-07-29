package cn.ray.design.utils;

import java.util.*;

public class TopicRandomUtil {

    /**
     * 乱序Map元素，记录对应答案key
     * @param option 题目
     * @param key    答案
     * @return Topic 乱序后 {A=c., B=d., C=a., D=b.}
     */
    static public Topic random(Map<String, String> option, String key) {
        Set<String> keySet = option.keySet();
        ArrayList<String> keyList = new ArrayList<String>(keySet);
        Collections.shuffle(keyList);  // 打乱原有答案集合的顺序
        HashMap<String, String> optionNew = new HashMap<String, String>();
        int idx = 0;
        String keyNew = "";
        for (String next : keySet) { // 乱序前的答案集合
            String randomKey = keyList.get(idx++);  // 顺序取乱序后的答案集合
            if (key.equals(next)) {
                keyNew = randomKey;   // 保证正确答案
            }
            optionNew.put(randomKey, option.get(next));
        }
        return new Topic(optionNew, keyNew);
    }

}
