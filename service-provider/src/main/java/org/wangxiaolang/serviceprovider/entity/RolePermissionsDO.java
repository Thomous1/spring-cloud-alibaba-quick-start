package org.wangxiaolang.serviceprovider.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName(value = "role_permissions")
public class RolePermissionsDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permissions.id
     *
     * @mbg.generated Thu Dec 05 14:25:33 CST 2024
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permissions.role_id
     *
     * @mbg.generated Thu Dec 05 14:25:33 CST 2024
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permissions.permission_id
     *
     * @mbg.generated Thu Dec 05 14:25:33 CST 2024
     */
    private Long permissionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permissions.created_at
     *
     * @mbg.generated Thu Dec 05 14:25:33 CST 2024
     */
    private Date createdAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permissions.id
     *
     * @return the value of role_permissions.id
     *
     * @mbg.generated Thu Dec 05 14:25:33 CST 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permissions.id
     *
     * @param id the value for role_permissions.id
     *
     * @mbg.generated Thu Dec 05 14:25:33 CST 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permissions.role_id
     *
     * @return the value of role_permissions.role_id
     *
     * @mbg.generated Thu Dec 05 14:25:33 CST 2024
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permissions.role_id
     *
     * @param roleId the value for role_permissions.role_id
     *
     * @mbg.generated Thu Dec 05 14:25:33 CST 2024
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permissions.permission_id
     *
     * @return the value of role_permissions.permission_id
     *
     * @mbg.generated Thu Dec 05 14:25:33 CST 2024
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permissions.permission_id
     *
     * @param permissionId the value for role_permissions.permission_id
     *
     * @mbg.generated Thu Dec 05 14:25:33 CST 2024
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permissions.created_at
     *
     * @return the value of role_permissions.created_at
     *
     * @mbg.generated Thu Dec 05 14:25:33 CST 2024
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permissions.created_at
     *
     * @param createdAt the value for role_permissions.created_at
     *
     * @mbg.generated Thu Dec 05 14:25:33 CST 2024
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}