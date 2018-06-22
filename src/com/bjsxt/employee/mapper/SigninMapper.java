package com.bjsxt.employee.mapper;

import com.bjsxt.employee.pojo.Signin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Time;
import java.util.List;

public interface SigninMapper {

    /**
    * 用户当日签到时插入当日签到的信息。
    *
    *@author leo
    *@param signin
    *@return int
    */

    @Insert("insert into t_attendance values (default,#{uid},curtime(),date_formate(now(),'%y-%m-%d'),null)")
    int insSign(Signin signin);

    /**
    * 根据user的ID查询自己的签到记录。
    *
    *@author leo
    *@param uid
    *@return {@link Signin}List<Signin>
    */

    @Select("select * from t_attendance where uid=#{0}")
    List<Signin> selSign(int uid);


    /**
    * 更新签退信息或签退。
    *
    *@author leo
    *@param id 当天签到的签到项ID
    *@return int
    */
    @Update("update t_attendance set qtdate=curtime() where id=#{0}")
    int insSignout(int id);
}
