package org.wangxiaolang.serviceprovider.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName(value = "user_roles")
public class UserRolesDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_roles.id
     *
     * @mbg.generated Thu Dec 05 14:25:18 CST 2024
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_roles.user_id
     *
     * @mbg.generated Thu Dec 05 14:25:18 CST 2024
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_roles.role_id
     *
     * @mbg.generated Thu Dec 05 14:25:18 CST 2024
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_roles.created_at
     *
     * @mbg.generated Thu Dec 05 14:25:18 CST 2024
     */
    private Date createdAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_roles.id
     *
     * @return the value of user_roles.id
     *
     * @mbg.generated Thu Dec 05 14:25:18 CST 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_roles.id
     *
     * @param id the value for user_roles.id
     *
     * @mbg.generated Thu Dec 05 14:25:18 CST 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_roles.user_id
     *
     * @return the value of user_roles.user_id
     *
     * @mbg.generated Thu Dec 05 14:25:18 CST 2024
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_roles.user_id
     *
     * @param userId the value for user_roles.user_id
     *
     * @mbg.generated Thu Dec 05 14:25:18 CST 2024
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_roles.role_id
     *
     * @return the value of user_roles.role_id
     *
     * @mbg.generated Thu Dec 05 14:25:18 CST 2024
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_roles.role_id
     *
     * @param roleId the value for user_roles.role_id
     *
     * @mbg.generated Thu Dec 05 14:25:18 CST 2024
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_roles.created_at
     *
     * @return the value of user_roles.created_at
     *
     * @mbg.generated Thu Dec 05 14:25:18 CST 2024
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_roles.created_at
     *
     * @param createdAt the value for user_roles.created_at
     *
     * @mbg.generated Thu Dec 05 14:25:18 CST 2024
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}