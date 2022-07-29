package cn.ray.design.design.card;

/**
 * @author JOJO
 * @date 2022/7/29 01:02
 * 模拟爱奇艺会员卡服务
 */
public class IQiYiCardService {
    public void grantToken(String bindMobileNumber,String cardId){
        System.out.println("模拟发放爱奇艺会员卡一张: "+bindMobileNumber+","+cardId);
    }
}
