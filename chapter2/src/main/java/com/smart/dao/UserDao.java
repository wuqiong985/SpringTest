package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wuqiong6 on 2018/2/28.
 */
@Repository //通过Spring注解定义一个DAO
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    private  final static String UPDATE_LOGIN_INFO_SQL = " UPDATE t_user SET " +
            " last_visit=?,last_ip=?,credits=?  WHERE user_id =?";

    @Autowired //2.自动注入JdbcTemplate 的 Bean
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getMatchCount(String userName,String password){
        String sqlStr = "select count(*) from t_user where user_name = ? and password = ?";
        return jdbcTemplate.queryForObject(sqlStr,new Object[]{userName,password},Integer.class);
    }

    public User findUserByUserName(final String userName){
        String sqlStr = "select user_id, user_name, credits from t_user where user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            //匿名类方法实现的回调函数
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(rs.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user) {
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, new Object[] { user.getLastVisit(),
                user.getLastIp(),user.getCredits(),user.getUserId()});
    }
}
