package com.skyeye.managesystem.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2018/11/9 10:19 AM
 * @since JDK 1.8
 */
public enum RoleTypeEnum {
    ADMIN(1,"管理员"),
    FINANCE(2,"财务"),
    STAFF(3,"员工")
    ;
    private Integer typeId;

    private String roleName;

    RoleTypeEnum(Integer typeId, String roleName) {
        this.typeId = typeId;
        this.roleName = roleName;
    }

    RoleTypeEnum() {
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    static Map<Integer,RoleTypeEnum> newMap = new HashMap<>();
    static {
        for (RoleTypeEnum role: RoleTypeEnum.values()){
            newMap.put(role.getTypeId(),role);
        }
    }

    public static String getRoleNameById(Integer typeId){
        return newMap.get(typeId).getRoleName();
    }
}
