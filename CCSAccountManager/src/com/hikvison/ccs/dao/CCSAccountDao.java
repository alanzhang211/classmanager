package com.hikvison.ccs.dao;

/**
 * 
 * <p>账户重置</p>
 * @author zhanghanqing 2014-12-22 下午04:31:28
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2014-12-22
 * @modify by reason:{方法名}:{原因}
 */
public class CCSAccountDao {
    /**依据人员编号重置消费账户*/
    private static final String RESET_CCS_ACCOUNT_BY_PERSONCODE = "update ccs_account set amount = 0 where person_id in (select person_id from oc_person where person_code in(?))";
    /**
     * 账户重置
     * @author zhanghanqing 2014-12-22 下午04:41:21
     * @param personCode 人员编号
     * @return boolean
     */
    public boolean resetAccountByPersonCode(String personCode) {
        
        return false;
    }
}
