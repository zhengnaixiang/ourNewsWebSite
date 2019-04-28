package com.qf.advertising.service.impl;

import com.qf.advertising.mapper.TbAdvertisingMapper;
import com.qf.advertising.pojo.TbAdvertising;
import com.qf.advertising.service.AdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AdvertisingServiceImpl implements AdvertisingService {
    @Autowired
    private TbAdvertisingMapper tbAdvertisingMapper;

    /**
     * 普通广告
     * @return
     */
    @Override
    public TbAdvertising ordinary() {
        List<TbAdvertising> ordinary = tbAdvertisingMapper.ordinary();
        Random random = new Random();
        int num = random.nextInt(ordinary.size());
        return ordinary.get(num);
    }

    /**
     * 滑动广告
     * @return
     */
    @Override
    public List<TbAdvertising> sliding() {
        List<TbAdvertising> sliding = tbAdvertisingMapper.sliding();
        List<TbAdvertising> list = new ArrayList<>();
        Random random = new Random();
        if (sliding.size() > 4){
            for (int i=0; i < 4; i++) {
                int randomIndex = random.nextInt(sliding.size());
                list.add(sliding.get(randomIndex));
                sliding.remove(randomIndex);
            }
            System.out.println("111111111"+list);


/*            int[] arr = {11111,11111,11111,11111};
            int num = 0;
            a:for (int i = 0; i < arr.length; i++) {
                num = random.nextInt(sliding.size());
                int a = 0;
                b:for (int j = 0; j < arr.length; j++) {
                    if (num != arr[j]){
                        a++;
                        if (a == arr.length){
                            arr[i] = num;
                            break b;
                        }
                    }else if (num == arr[j]){
                        i--;
                        break b;
                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                TbAdvertising tbAdvertising = sliding.get(arr[i]);
                System.out.println(i + ":" + tbAdvertising);
                list.add(tbAdvertising);
            }*/
        }else {
            return sliding;
        }
        return list;
    }
}
