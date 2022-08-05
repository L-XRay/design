package cn.ray.design.impl;

import cn.ray.design.AuthInfo;
import cn.ray.design.AuthLink;
import cn.ray.design.AuthService;

import java.text.ParseException;
import java.util.Date;

/**
 * @author JOJO
 * @date 2022/8/5 08:13
 * 二级审批，大促前
 */
public class Level2AuthLink extends AuthLink {

    private Date beginDate = f.parse("2020-08-11 00:00:00");
    private Date endDate = f.parse("2022-08-20 23:59:59");

    public Level2AuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待二级审批负责人 ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：二级审批完成负责人", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        if (authDate.before(endDate) || authDate.after(beginDate)) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：二级审批完成负责人", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }

}
